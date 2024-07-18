package Work3;

/* 
 * クラス名 Judge
 * 概要 ジャンケンの勝者を判定する
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class Judge {

	/* 
	 * 関数名 startJanken
	 * 概要 ジャンケンを指定された回数行い、最終的な勝者を決定する
	 * 引数 二人のプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public void startJanken(Player firstPlayer, Player secondPlayer) {
		//ジャンケン開始を表示
		System.out.println("【ジャンケン開始】\n");
		//ジャンケンをする回数を表す定数を設定
		final int JANKEN_TIMES = 3;
		//ジャンケンを三回行う
		for (int cnt = 0; cnt < JANKEN_TIMES;) {
			//現在何回戦目かを表示
			System.out.println("【" + ++cnt + "回戦目】");
			//勝者の情報を持つインスタンスを作成
			Player winnerPlayer = judgeJanken(firstPlayer, secondPlayer);
			//勝者がいる場合
			if (winnerPlayer != null) {
				//勝利したプレイヤー名を表示
				System.out.println("\n" + winnerPlayer.getName() + "が勝ちました！\n");
				//勝者の勝利数に1加算
				winnerPlayer.notyfyResult(true);
				//引き分けの場合
			} else {
				//引き分けであることを表示
				System.out.println("\n引き分けです！\n");
			}

		}
		//ジャンケン終了を表示
		System.out.println("【ジャンケン終了】\n");
		//最終的な勝者の情報を持つインスタンスを作成
		Player finalWinner = judgeFinalWinner(firstPlayer, secondPlayer);

		//ジャンケン開始を表示
		System.out.print(firstPlayer.getWinCount() + "対" + secondPlayer.getWinCount() + "で");
		//最終的な勝者が存在する場合
		if (finalWinner != null) {
			//最終的な勝者の名前を表示
			System.out.println(finalWinner.getName() + "の勝ちです！\n");
			//引き分けの場合
		} else {
			//引き分けであることを表示
			System.out.println("引き分けです！\n");
		}
	}

	/* 
	 * 関数名 judgeJanken
	 * 概要 ジャンケンの勝者を決定する
	 * 引数 二人のプレイヤー(Player)
	 * 返り値 勝利したプレイヤー(Player)、もしくは引き分け(null)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	private Player judgeJanken(Player firstPlayer, Player secondPlayer) {
		//勝者を表す変数を作成し、初期値にnullを代入
		Player winnerPlayer = null;
		//プレイヤー1の手を表す変数を設定し、ランダムな手を設定
		int firstPlayerHand = firstPlayer.showHand();
		//プレイヤー2の手を表す変数を設定し、ランダムな手を設定
		int secondPlayerHand = secondPlayer.showHand();
		//関数を用いて、プレイヤー1の手を表示
		printHand(firstPlayerHand);
		//繋ぐための文字を表示
		System.out.print("vs.");
		//関数を用いて、プレイヤー2の手を表示
		printHand(secondPlayerHand);
		//改行する
		System.out.print("\n");

		//プレイヤー1が勝利した場合
		if ((firstPlayerHand == Player.STONE_HAND && secondPlayerHand == Player.SCISSORS_HAND)
				|| (firstPlayerHand == Player.SCISSORS_HAND && secondPlayerHand == Player.PAPER_HAND)
				|| (firstPlayerHand == Player.PAPER_HAND && secondPlayerHand == Player.STONE_HAND)) {
			//勝者のインスタンスにプレイヤー1を代入
			winnerPlayer = firstPlayer;
			//プレイヤー2が勝利した場合
		} else if ((secondPlayerHand == Player.STONE_HAND && firstPlayerHand == Player.SCISSORS_HAND)
				|| (secondPlayerHand == Player.SCISSORS_HAND && firstPlayerHand == Player.PAPER_HAND)
				|| (secondPlayerHand == Player.PAPER_HAND && firstPlayerHand == Player.STONE_HAND)) {
			//勝者のインスタンスにプレイヤー2を代入
			winnerPlayer = secondPlayer;
		}
		//勝者のインスタンスを返却する
		return winnerPlayer;
	}

	/* 
	 * 関数名 judgeFinalWinner
	 * 概要 最終的な勝者を決定する
	 * 引数 二人のプレイヤー(Player)
	 * 返り値 勝利したプレイヤー(Player)、もしくは引き分け(null)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	private Player judgeFinalWinner(Player firstPlayer, Player secondPlayer) {
		//勝者を表す変数を作成し、初期値にnullを代入
		Player winnerPlayer = null;
		//プレイヤー1の勝利数を表す変数を設定し、勝利数を代入
		int firstPlayerWinCount = firstPlayer.getWinCount();
		//プレイヤー2の勝利数を表す変数を設定し、勝利数を代入
		int secondPlayerWinCount = secondPlayer.getWinCount();
		//プレイヤー1の方が勝利数が多い場合
		if (firstPlayerWinCount > secondPlayerWinCount) {
			//勝者を表す変数にプレイヤー1を代入
			winnerPlayer = firstPlayer;
			//プレイヤー2の方が勝利数が多い場合
		} else if (firstPlayerWinCount < secondPlayerWinCount) {
			//勝者を表す変数にプレイヤー1を代入
			winnerPlayer = secondPlayer;
		}
		//勝者を表すインスタンスを返却
		return winnerPlayer;
	}

	/* 
	 * 関数名 printHand
	 * 概要 プレイヤーの手を文字で表示する
	 * 引数 プレイヤーの手(int)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	private void printHand(int playerHand) {
		//プレイヤーの手によって分岐する
		switch (playerHand) {
		//プレイヤーの手がグーの場合
		case Player.STONE_HAND:
			//グーの手を表示
			System.out.print("グー");
			//分岐を終了
			break;
		//プレイヤーの手がチョキの場合
		case Player.SCISSORS_HAND:
			//チョキの手を表示
			System.out.print("チョキ");
			//分岐を終了
			break;
		//プレイヤーの手がパーの場合
		case Player.PAPER_HAND:
			//パーの手を表示
			System.out.print("パー");
			//分岐を終了
			break;
		}
	}

}
