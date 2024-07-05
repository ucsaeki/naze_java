package Work4;

/* 
 * クラス名 MurataEx
 * 概要 村田さんの情報を管理する、Playerのサブクラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class MurataEx extends Player{
	/* 
	 * コンストラクタ名 MurataEx
	 * 概要 インスタンスの名前の初期値を設定する
	 * 引数 プレイヤーの名前(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public MurataEx(String playerName) {
		//スーパークラスのコンストラクタを用いて、インスタンスに名前を設定
		super(playerName);
	}
	/* 
	 * 関数名 showHand
	 * 概要 プレイヤーの出す手を決める
	 * 引数 なし
	 * 返り値 出す手の値(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public int showHand() {
		//グーを表す定数を返却
		return STONE_HAND;
	}
	
}