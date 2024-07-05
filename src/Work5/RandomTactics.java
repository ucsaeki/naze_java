package Work5;

/* 
 * クラス名 RandomTactics
 * 概要 ランダムな手を出すTacticsインタフェースの実装クラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class RandomTactics implements Tactics {
	/* 
	 * 関数名 readTactics
	 * 概要 ランダムな手を出す
	 * 引数 なし
	 * 返り値 選ばれたランダムな手(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public int readTactics() {
		//乱数を格納するための変数を設定
		double randomNumber = 0;
		//プレイヤーの手を表す変数を設定
		int playerHand = 0;
		//乱数にかけてプレイヤーの手を決めるための定数を設定
		final int HAND_SELECT = 3;
		//乱数を格納するための変数に、求めた乱数を代入
		randomNumber = Math.random() * HAND_SELECT;
		//乱数が1より小さい場合
		if (randomNumber < 1) {
			//プレイヤーの手を表す変数にグーを表す定数を代入
			playerHand = Player.STONE_HAND;
			//乱数が2より小さい場合
		} else if (randomNumber < 2) {
			//プレイヤーの手を表す変数にチョキを表す定数を代入
			playerHand = Player.SCISSORS_HAND;
			//それ以外の場合
		} else if (randomNumber < 3) {
			//プレイヤーの手を表す変数にパーを表す定数を代入
			playerHand = Player.PAPER_HAND;
		}
		//プレイヤーの手を返却
		return playerHand;
	}
}
