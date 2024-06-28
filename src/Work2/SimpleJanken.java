package Work2;

/* 
 * クラス名 SimpleJanken
 * 概要 コンピュータ二人でジャンケンを三回行い勝者を決める
 * 作成者 Y.Saeki
 * 作成日 2024/06/28
 */
public class SimpleJanken {
	//グーを表す定数を静的宣言
	public static final int STONE_HAND = 0;
	//チョキを表す定数を静的宣言
	public static final int SCISSORS_HAND = 1;
	//パーを表す定数を静的宣言
	public static final int PAPER_HAND = 2;

	/* 
	 * 関数名 main
	 * 概要 コンピュータ二人でジャンケンを三回行い勝者を決める
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/06/28
	 */
	public static void main(String[] args) {
		//ジャンケン開始を宣言
		System.out.println("【ジャンケン開始】\n");

		//プレイヤー1の勝利数を表す変数を設定
		int player1WinCount = 0;
		//プレイヤー2の勝利数を表す変数を設定
		int player2WinCount = 0;
		//ジャンケンをした回数を表す変数を設定
		int battleCount = 0;

		//ジャンケンを3回行う
		for (int cnt = 0; cnt < 3; cnt++) {
			
			battleCount++;
			
			System.out.println("【" + battleCount +"回戦目】");
			
			//乱数を格納するための変数を設定
			double randomNumber = 0;
			//プレイヤー1の手を表す変数を設定
			int player1Hand = 0;
			//乱数にかけてプレイヤーの手を決めるための定数を設定
			final int HAND_SELECT = 3;
			//乱数を格納するための変数に、求めた乱数を代入
			randomNumber = Math.random() * HAND_SELECT;
			//乱数が1より小さい場合
			if (randomNumber < 1) {
				//プレイヤー1の手を表す変数にグーを表す定数を代入
				player1Hand = STONE_HAND;
				//グーの手を表示
				System.out.print("グー");
				//乱数が2より小さい場合
			} else if (randomNumber < 2) {
				//プレイヤー1の手を表す変数にチョキを表す定数を代入
				player1Hand = SCISSORS_HAND;
				//チョキの手を表示
				System.out.print("チョキ");
				//それ以外の場合
			} else if (randomNumber < 3) {
				//プレイヤー1の手を表す変数にパーを表す定数を代入
				player1Hand = PAPER_HAND;
				//パーの手を表示
				System.out.print("パー");
			}
			
			System.out.print(" vs. ");

			//プレイヤー2の手を表す変数を設定
			int player2Hand = 0;
			//乱数を格納するための変数に、求めた乱数を代入
			randomNumber = Math.random() * HAND_SELECT;
			//乱数が1より小さい場合
			if (randomNumber < 1) {
				//プレイヤー2の手を表す変数にグーを表す定数を代入
				player2Hand = STONE_HAND;
				//グーの手を表示
				System.out.println("グー");
				//乱数が2より小さい場合
			} else if (randomNumber < 2) {
				//プレイヤー2の手を表す変数にチョキを表す定数を代入
				player2Hand = SCISSORS_HAND;
				//チョキの手を表示
				System.out.println("チョキ");
				//それ以外の場合
			} else if (randomNumber < 3) {
				//プレイヤー2の手を表す変数にパーを表す定数を代入
				player2Hand = PAPER_HAND;
				//パーの手を表示
				System.out.println("パー");
			}

			//プレイヤー1が勝利する場合
			if ((player1Hand == STONE_HAND && player2Hand == SCISSORS_HAND)
					|| (player1Hand == SCISSORS_HAND && player2Hand == PAPER_HAND)
					|| (player1Hand == PAPER_HAND && player2Hand == STONE_HAND)) {
				//プレイヤー1の勝利数に1加算
				player1WinCount++;
				//プレイヤー1が勝利したことを表示
				System.out.println("プレイヤー1が勝ちました！\n");

			} else if ((player2Hand == STONE_HAND && player1Hand == SCISSORS_HAND)
					|| (player2Hand == SCISSORS_HAND && player1Hand == PAPER_HAND)
					|| (player2Hand == PAPER_HAND && player1Hand == STONE_HAND)) {
				//プレイヤー2の勝利数に1加算
				player2WinCount++;
				//プレイヤー2が勝利したことを表示
				System.out.println("プレイヤー2が勝ちました！\n");
				//引き分けの場合
			}else {
				//引き分けであることを表示
				System.out.println("引き分けです！\n");
			}
			
		}

		//ジャンケン終了を宣言
		System.out.println("【ジャンケン終了】\n");
		//プレイヤー1の勝利数がプレイヤー2の勝利数より多い場合
		if (player1WinCount > player2WinCount) {
			//プレイヤー1が勝利したことを表示
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー1の勝ちです！\n");
		//プレイヤー2の勝利数がプレイヤー1の勝利数より多い場合
		} else if (player1WinCount < player2WinCount) {
			//プレイヤー2が勝利したことを表示
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー2の勝ちです！\n");
		//プレイヤー1とプレイヤー2の勝利数が同じ場合
		} else if (player1WinCount == player2WinCount) {
			//引き分けであることを表示
			System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです！\n");
		}

	}

}
