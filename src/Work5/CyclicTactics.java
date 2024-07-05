package Work5;

/* 
 * クラス名 CyclicTactics
 * 概要 グー、チョキ、パーを順番に出すTacticsインタフェースの実装クラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class CyclicTactics implements Tactics {
	//ジャンケンの回数を表すフィールドを設定
	public int jankenCount = 0;

	/* 
	 * 関数名 readTactics
	 * 概要 グー、チョキ、パーを順番に出す
	 * 引数 なし
	 * 返り値 その順番の手(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public int readTactics() {
		//手を表す変数を設定
		int selectedHand = 0;
		//ジャンケンの回数に1加算
		jankenCount++;
		//ジャンケンの回数によって分岐
		switch (jankenCount) {
		//一回戦の時
		case 1:
			//手を表す変数にグーを表す定数を代入
			selectedHand = Player.STONE_HAND;
			//繰り返しを終了する
			break;
		//一回戦の時
		case 2:
			//手を表す変数にグーを表す定数を代入
			selectedHand = Player.SCISSORS_HAND;
			//繰り返しを終了する
			break;
		//一回戦の時
		case 3:
			//手を表す変数にグーを表す定数を代入
			selectedHand = Player.PAPER_HAND;
			//繰り返しを終了する
			break;
		}
		//選択された手を返却する
		return selectedHand;

	}

}
