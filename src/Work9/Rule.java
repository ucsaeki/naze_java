package Work9;
/* 
 * インタフェース名 Rule
 * 概要 ルールに関する情報を管理するインタフェース
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public interface Rule {
	/* 
	 * 関数名 findCandidate
	 * 概要 手札とテーブルを確認して置けるカードを探す
	 * 引数 手札(Hand)、テーブル(Table)
	 * 返り値 置けるカードの組み合わせ(Card[])、もしくは置けるカードがない(null)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card[] findCandidate(Hand variableHand, Table variableTable) ;
	
}
