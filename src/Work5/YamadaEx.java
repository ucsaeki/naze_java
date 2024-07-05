package Work5;
/* 
 * クラス名 YamadaEx
 * 概要 山田さんの情報を管理する、Playerのサブクラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class YamadaEx extends Player{
	/* 
	 * コンストラクタ名 YamadaEx
	 * 概要 インスタンスの名前の初期値を設定する
	 * 引数 プレイヤーの名前(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public YamadaEx(String playerName) {
		//スーパークラスのコンストラクタを用いて、インスタンスに名前を設定
		super(playerName);
	}
	
}
