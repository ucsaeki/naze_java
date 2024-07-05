package Work9;
/* 
 * クラス名 Joker
 * 概要 ジョーカーを管理する、Cardのサブクラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public class Joker extends Card{
	/* 
	 * コンストラクタ名 Joker
	 * 概要 ジョーカーを表すカードを初期化する
	 * 引数 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Joker() {
		//スーパークラスのコンストラクタを用いて、ジョーカーを表す値に初期化
		super(0,0);
	}
	/* 
	 * 関数名 setNumber
	 * 概要 カードの数字を設定する
	 * 引数 設定する数字(int)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void setNumber(int variableNumber) {
		//フィールドに引数を代入
		this.cardNumber = variableNumber;
	}
	/* 
	 * 関数名 setNumber
	 * 概要 カードのスートを設定する
	 * 引数 設定するスート(int)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void setSuit(int variableSuit) {
		//フィールドに引数を代入
		this.cardSuit = variableSuit;
	}
	
	/* 
	 * 関数名 toString
	 * 概要 ジョーカーを表す文字列を表示する
	 * 引数 なし
	 * 返り値 ジョーカーを表す文字列(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public String toString() {
		//ジョーカーを表す文字列を返却
		return "JK";
	}
	
	
	
	
}
