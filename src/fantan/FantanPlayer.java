package fantan;

//Cardクラスをインポート
import Work9.Card;
//Masterクラスをインポート
import Work9.Master;
//Playerクラスをインポート
import Work9.Player;
//Ruleクラスをインポート
import Work9.Rule;
//Tableクラスをインポート
import Work9.Table;

/* 
 * クラス名 FantanPlayer
 * 概要 七並べプレイヤーを管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/04
 */
public class FantanPlayer extends Player {
	//パス回数を表すフィールドを宣言
	private int passCount = 0;

	/* 
	 * コンストラクタ名 FantanPlayer
	 * 概要 七並べプレイヤーのフィールドを初期化する
	 * 引数 名前(String)、テーブル(Table)、手札(Hand)、進行役(Master)、ルール(Rule)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public FantanPlayer(String playerName, Table cardTable, Master myMaster, Rule myRule) {
		//プレイヤー名、テーブル、進行役、ルールを初期化する
		super(playerName, cardTable, myMaster, myRule);
	}

	/* 
	 * 関数名 recieivedCard
	 * 概要 受け取ったカードが7だった場合テーブルに置き、それ以外の場合手札に加える。
	 * 引数 配られたカード(Card)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public void receiveCard(Card dealtCard) {
		//七並べで最初に捨てるカードの番号を表す定数を設定
		final int TARGET_NUMBER = 7;
		//配られたカードが対象の数字だった場合
		if (dealtCard.getNumber() == TARGET_NUMBER) {
			//テーブルに置くカードを表示
			System.out.println(playerName + " : " + dealtCard + "を置きました。");
			//テーブルに対象のカードを置く
			cardTable.putCard(new Card[] { dealtCard });
			//対象の数字意外だった場合
		} else {
			//カードを手札に加える
			super.receiveCard(dealtCard);
		}
	}

	/* 
	 * 関数名 playGame
	 * 概要 テーブルに置けるカードがあれば置き、無ければパスをする。
	 * 引数 次の手番のプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public void playGame(Player nextPlayer) {
		//手札を表示する
		System.out.println(" " + myHand);
		//置ける手札を格納した配列を作成
		Card[] candidateCard = myRule.findCandidate(myHand, cardTable);

		//置けるカードが存在する場合
		if (candidateCard != null) {
			//テーブルに置くカードを表示
			System.out.println(" " + candidateCard[0] + "を置きました。\n");
			//テーブルにカードを置く
			cardTable.putCard(candidateCard);
			//並べた後のテーブルを表示
			System.out.println(cardTable);

			//手札が0枚になった場合
			if (myHand.getNumberOfCards() == 0) {
				//上がりを宣言する
				myMaster.decleareWin(this);
			}
			//　置けるカードが無い場合
		} else {
			//パス回数の累計に1加算
			passCount++;
			//パスを行う
			((FantanMaster) myMaster).passTurn(this);
			//プレイヤーのパス回数がパス可能回数を越えた場合
			if (passCount > FantanMaster.PASS_LIMIT) {
				//手札の枚数を表す定数を取得
				int numberOfHand = myHand.getNumberOfCards();
				//全ての手札をテーブルに置く
				for (int i = 0; i < numberOfHand; i++) {
					//手札のカードをテーブルに置く
					cardTable.putCard(new Card[] {myHand.pickCard(0)});
				}
			}
		}
	}

	/* 
	 * 関数名 getPass
	 * 概要 パス回数を返却する
	 * 引数 なし
	 * 返り値 パス回数(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public int getPass() {
		//パス回数を返却する
		return passCount;
	}
}
