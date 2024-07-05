package Work9;
/* 
 * インタフェース名 Table
 * 概要 テーブルを表すインタフェース
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public interface Table {
	/* 
	 * 関数名 putCard
	 * 概要 カードをテーブルに置く
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void putCard(Card[] variableCard);
	
	/* 
	 * 関数名 getCards
	 * 概要 テーブルのカードを見る
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card[][] getCards();
}
