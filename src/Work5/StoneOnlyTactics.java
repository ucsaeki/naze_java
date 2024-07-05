package Work5;
/* 
 * クラス名 StoneOnlyTactics
 * 概要 必ずグーを出すTacticsインタフェースの実装クラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class StoneOnlyTactics implements Tactics{

	/* 
	 * 関数名 readTactics
	 * 概要 必ずグーを出す
	 * 引数 なし
	 * 返り値 グー(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public int readTactics() {
		//グーを表す定数を返却
		return Player.STONE_HAND;
	}
}
