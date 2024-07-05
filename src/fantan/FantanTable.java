package fantan;

//Cardクラスをインポート
import Work9.Card;
//Tableインタフェースをインポート
import Work9.Table;

/* 
 * クラス名 FantanTable
 * 概要 七並べテーブルを管理するクラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public class FantanTable implements Table {
	//七並べテーブルを表すフィールドを宣言
	private Card[][] fantanTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];

	/* 
	 * 関数名 putCard
	 * 概要 カードを七並べテーブルに置く
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
		fantanTable[cardSuit + ADJUST_INDEX][cardNumber + ADJUST_INDEX] = putingCard[0];
	}

	/* 
	 * 関数名 getCards
	 * 概要 七並べテーブルのカードを見る
	 * 引数 なし
	 * 返り値 コピーした七並べテーブル(Card[][])
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card[][] getCards() {
		//七並べテーブルのコピーを入力するための二次元配列を作成
		Card[][] copyFantanTable = new Card[Card.SUIT_NUMBER][Card.CARD_NUMBER];
		//二次元配列内の全ての要素をコピーする
		for (int i = 0; i < Card.SUIT_NUMBER; i++) {
			//コピーテーブルの対応する箇所に元のテーブルの値を挿入
			System.arraycopy(fantanTable[i], 0, copyFantanTable[i], 0, Card.CARD_NUMBER);
		} //作成したコピーを返却
		return copyFantanTable;
	}

	/* 
	 * 関数名 toString
	 * 概要 七並べテーブルを表示する
	 * 引数 なし
	 * 返り値 七並べテーブルを表す文字列(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public String toString() {
		//StringBufferクラスに変数を設定
		StringBuffer stringBuffer = new StringBuffer();

		//二次元配列内の全ての要素をコピーする
		for (int i = 0; i < fantanTable.length; i++) {
			//配列の要素をコピーする
			for (int j = 0; j < fantanTable[i].length; j++) {
				//その位置にカードが存在する場合
				if (fantanTable[i][j] != null) {
					//カードを表す変数にリスト内のカードを代入
					Card variableCard = (Card) fantanTable[i][j];
					//カードを表示
					stringBuffer.append(variableCard);
				//カードが存在しない場合
				} else {
					//カードが存在しないことを表示
					stringBuffer.append("･･");
				}
				//調整のための空白を表示
				stringBuffer.append(" ");
			}
			//改行する
			stringBuffer.append("\n");
		}
		//七並べテーブルを表す文字列を表示
		return stringBuffer.toString();
	}

}
