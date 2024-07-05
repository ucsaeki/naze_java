package OldMaid;

//Cardクラスをインポート
import Work9.Card;
//Handクラスをインポート
import Work9.Hand;
//Masterクラスをインポート
import Work9.Master;
//Playerクラスをインポート
import Work9.Player;
//Ruleクラスをインポート
import Work9.Rule;
//Tableクラスをインポート
import Work9.Table;

/* 
 * クラス名 OldMaidPlayer
 * 概要 ババ抜きプレイヤーを管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/04
 */
public class OldMaidPlayer extends Player {
	/* 
	 * コンストラクタ名 OldMaidPlayer
	 * 概要 ババ抜きプレイヤーのフィールドを初期化する
	 * 引数 名前(String)、テーブル(Table)、進行役(Master)、ルール(Rule)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public OldMaidPlayer(String playerName, Table cardTable, Master myMaster, Rule myRule) {
		//スーパークラスのコンストラクタを使用して、名前、テーブル、手札、進行役、ルールを初期化する
		super(playerName, cardTable, myMaster, myRule);
	}

	/* 
	 * 関数名 playGame
	 * 概要 隣の人の手札から一枚引いて、同じ数字のカードを持っていた場合捨てる
	 * 引数 次の手番のプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public void playGame(Player nextPlayer) {
		//次の人の手を確認する
		Hand nextHand = ((OldMaidPlayer) nextPlayer).showHand();

		//次の人からカードを引く。
		Card pickedCard = nextHand.pickCard(0);
		//次の人から引いたカードを表示
		System.out.println(this + " : " + nextPlayer + "さんから " + pickedCard + " を引きました");
		//受け取ったカードを手札に加え、同じ数字のカードがあった場合テーブルに置く
		this.receiveCard(pickedCard);
		//残りの手札が0枚になった場合
		if (myHand.getNumberOfCards() == 0) {
			//勝利を宣言する
			myMaster.decleareWin(this);
			//手札が残っている場合
		} else {
			//残りの手札を表示
			System.out.println(" " + "残りの手札は " + myHand + "です");
		
		}
	}

	/* 
	 * 関数名 showHand
	 * 概要 相手に手札を見せる
	 * 引数 なし
	 * 返り値 手札(Hand)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public Hand showHand() {
		//手札が一枚の場合
		if( myHand.getNumberOfCards() == 1) {
			//勝利を宣言する
			myMaster.decleareWin(this);
		}
		//手札をシャッフルする
		myHand.shuffleCard();
		//手札を返却する
		return myHand;

	}
	/* 
	 * 関数名 reciveCard
	 * 概要 カードを手札に加えた際、手札に同じ数字のカードがある場合にテーブルに置く
	 * 引数 加えたいカード(Card)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/05
	 */
	public void receiveCard(Card receivedCard) {
		//受けとったカードを手札の最後尾に追加する
		myHand.addCard(receivedCard);
		//手札と同じ要素数を持つ配列を生成
		Card[] sameCards = new Card[] {};
		//手札から同じ数字のカードを探す
		sameCards = myRule.findCandidate(myHand, cardTable);
		//同じ数字のカードが存在した場合
		if (sameCards != null) {
			//捨てたカードを表示
			System.out.println(playerName + " : " + sameCards[0] + " " + sameCards[1] + " を捨てました");
			//同じ数字のカードをテーブルに置く
			cardTable.putCard(sameCards);
		//存在しない場合
		}else {
			//受けとったカードを手札の最後尾に追加する
			myHand.addCard(receivedCard);
		}
	}
	
	
	
	
	

}
