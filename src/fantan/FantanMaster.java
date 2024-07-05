package fantan;
//Masterクラスをインポート
import Work9.Master;
/* 
 * クラス名 FantanMaster
 * 概要 七並べの進行役を管理するMasterのサブクラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/04
 */
public class FantanMaster extends Master{
	//パスの制限回数を表す定数を設定
	public static final int PASS_LIMIT = 3;
	/* 
	 * 関数名 passTurn
	 * 概要 パスを宣言する
	 * 引数 パスをするプレイヤー(FantanPlayer)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public void passTurn(FantanPlayer passPlayer) {
		//パスをしたプレイヤーとそのプレイヤーのパス回数を表示
		System.out.println(passPlayer + "さんは" + passPlayer.getPass() + "回目のパスをしました！");
		//プレイヤーのパス回数がパスの制限回数を越えた場合
		if(passPlayer.getPass() > PASS_LIMIT) {
			//そのプレイヤーの敗北を宣言
			System.out.println(passPlayer + "さんの負けです！");
			//負けたプレイヤーをゲームから除外する
			deregisterPlayer(passPlayer);
		}
	}

}
