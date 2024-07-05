package fantan;

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
 * クラス名 Fantan
 * 概要 各インスタンスを生成して七並べを行う
 * 作成者 Y.Saeki
 * 作成日 2024/07/04
 */
public class Fantan {
	/* 
	 * 関数名 createTrump
	 * 概要 山札を生成する
	 * 引数 なし
	 * 返り値 山札(Hand)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	private static Hand createTrump() {
		//山札のインスタンスを生成
		Hand trumpDeck = new Hand();
		//52枚のカードを生成して山札に挿入する
		for (int i = 1; i <= Card.CARD_NUMBER; i++) {
			//クラブのカードを生成
			trumpDeck.addCard(new Card(Card.SUIT_CLUB, i));
			//ダイヤのカードを生成
			trumpDeck.addCard(new Card(Card.SUIT_DIAMOND, i));
			//ハートのカードを生成
			trumpDeck.addCard(new Card(Card.SUIT_HEART, i));
			//スペードのカードを生成
			trumpDeck.addCard(new Card(Card.SUIT_SPADE, i));
		}
		//生成した山札を返却
		return trumpDeck;
	}

	/* 
	 * 関数名 main
	 * 概要 七並べを行う
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public static void main(String[] args) {
		//進行役のインスタンスを生成
		Master gameMaster = new FantanMaster();
		//テーブルのインスタンスを生成
		Table fantanTable = new FantanTable();
		//ルールのインスタンスを生成
		Rule fantanRule = new FantanRule();
		//プレイヤー村田のインスタンスを生成
		Player playerMurata = new FantanPlayer("村田", fantanTable, gameMaster, fantanRule);
		//プレイヤー山田のインスタンスを生成
		Player playerYamada = new FantanPlayer("山田", fantanTable, gameMaster, fantanRule);
		//プレイヤー斎藤のインスタンスを生成
		Player playerSaito = new FantanPlayer("斎藤", fantanTable, gameMaster, fantanRule);

		//プレイヤー村田を参加者リストに追加
		gameMaster.registerPlayer(playerMurata);
		//プレイヤー山田を参加者リストに追加
		gameMaster.registerPlayer(playerYamada);
		//プレイヤー斎藤を参加者リストに追加
		gameMaster.registerPlayer(playerSaito);
		//山札を生成
		Hand trumpDeck = createTrump();
		//山札からカードを配りゲーム開始の準備を行う
		gameMaster.prepareGame(trumpDeck);
		//最後の一人になるまで七並べを行う
		gameMaster.startGame();
	}

}
