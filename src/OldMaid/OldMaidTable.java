package OldMaid;

//Cardクラスをインポート
import Work9.Card;
//Tableクラスをインポート
import Work9.Table;

/* 
 * クラス名 OldMaidTable
 * 概要 ババ抜きテーブルを管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/04
 */
public class OldMaidTable implements Table {
	//ババ抜きテーブルのカードを格納するためのリストを作成
	private Card[][] disposedCards = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];

	/* 
	 * 関数名 putCard
	 * 概要 カードをババ抜きテーブルに置く
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void putCard(Card[] putingCard) {
		//スートを表す変数を設定し、カードのスートを取得して代入
		int cardSuit = putingCard[0].getSuit();
		//数字を表す変数を設定し、カードの数字を取得して代入
		int cardNumber = putingCard[0].getNumber();
		//インデックスの値のずれを修正するための定数を設定
		final int ADJUST_INDEX = -1;

		//七並べテーブルの対応する位置にカードの値を格納する
		disposedCards[cardSuit + ADJUST_INDEX][cardNumber + ADJUST_INDEX] = putingCard[0];
	}

	/* 
	 * 関数名 getCards
	 * 概要 ババ抜きテーブルを取得する
	 * 引数 なし
	 * 返り値 ババ抜きテーブルを表す配列(Card[][])
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	@Override
	public Card[][] getCards() {
		//ババ抜きテーブルのコピーを入力するための二次元配列を作成
		Card[][] copyTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];
		//二次元配列内の全ての要素をコピーする
		for (int i = 0; i < Card.SUIT_NUMBER; i++) {
			//コピーテーブルの対応する箇所に元のテーブルの値を挿入
			System.arraycopy(disposedCards[i], 0, copyTable[i], 0, Card.CARD_NUMBER);
		} //作成したコピーを返却
		return copyTable;
	}
}
