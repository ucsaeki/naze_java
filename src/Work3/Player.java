package Work3;

/* 
 * クラス名 Player
 * 概要 プレイヤーの情報を管理する
 * 作成者 Y.Saeki
 * 作成日 2024/06/28
 */
public class Player {
	//グーを表すクラス定数を宣言
	public static final int STONE_HAND = 0;
	//チョキを表すクラス定数を宣言
	public static final int SCISSORS_HAND = 1;
	//パーを表すクラス定数を宣言
	public static final int PAPER_HAND = 2;

	//プレイヤー名を表すフィールドを宣言
	private String playerName = "";
	//プレイヤーの勝利数を表すフィールドを宣言し、初期値として勝利数が無い状態を入力
	private int winCount = 0;
	
	/* 
	 * コンストラクタ名 Player
	 * 概要 コンストラクタを入力された名前で初期化する
	 * 引数 プレイヤー名(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/06/28
	 */
	public Player(String playerName) {
		//プレイヤー名のフィールドを入力された名前で初期化する
		this.playerName = playerName;
	}

	/* 
	 * 関数名 showHand
	 * 概要 ジャンケンの手を決めて表示する
	 * 引数 なし
	 * 返り値 プレイヤーの手(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/06/28
	 */
	public int showHand() {
		//乱数を格納するための変数を設定
		double randomNumber = 0;
		//プレイヤーの手を表す変数を設定
		int playerHand = 0;
		//乱数にかけてプレイヤーの手を決めるための定数を設定
		final int HAND_SELECT = 3;
		//グーを表す乱数の範囲を表す定数を設定
		final int STONE_RANGE = 1;
		//チョキを表す乱数の範囲を表す定数を設定
		final int SCISSORS_RANGE = 2;
		//パーを表す乱数の範囲を表す定数を設定
		final int PAPER_RANGE = 3;
		
		//乱数を格納するための変数に、求めた乱数を代入
		randomNumber = Math.random() * HAND_SELECT;
		//乱数が1より小さい場合
		if (randomNumber < STONE_RANGE) {
			//プレイヤーの手を表す変数にグーを表す定数を代入
			playerHand = STONE_HAND;
			//乱数が2より小さい場合
		} else if (randomNumber < SCISSORS_RANGE) {
			//プレイヤーの手を表す変数にチョキを表す定数を代入
			playerHand = SCISSORS_HAND;
			//乱数が3より小さい場合
		} else if (randomNumber < PAPER_RANGE) {
			//プレイヤーの手を表す変数にパーを表す定数を代入
			playerHand = PAPER_HAND;
		}
		//プレイヤーの手を返却
		return playerHand;
	}

	/* 
	 * 関数名 notyfyResult
	 * 概要 勝利した回数を記録する
	 * 引数 ジャンケンの勝敗(boolean)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/06/28
	 */
	public void notyfyResult(boolean jankenResalt) {
		//勝利した場合
		if (jankenResalt == true) {
			//勝利数に1加算
			winCount++;
		}
	}

	/* 
	 * 関数名 getWinCount
	 * 概要 勝利数を返却する
	 * 引数 なし
	 * 返り値 勝利数(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/06/28
	 */
	public int getWinCount() {
		//勝利数を返却
		return winCount;
	}
	/* 
	 * 関数名 getName
	 * 概要 プレイヤー名を返却する
	 * 引数 なし
	 * 返り値 プレイヤー名(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/06/28
	 */
	public String getName() {
		//プレイヤー名を返却する
		return playerName;
	}

}
