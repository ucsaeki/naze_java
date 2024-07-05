package Work6;

/* 
 * クラス名 Card
 * 概要 カードの情報を管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/02
 */
public class Card {
	//ジョーカーを表す静的定数を設定
	public static final int SUIT_JOKER = 0;
	//スペードを表す静的定数を設定
	public static final int SUIT_SPADE = 1;
	//ダイヤを表す静的定数を設定
	public static final int SUIT_DIAMOND = 2;
	//クラブを表す静的定数を設定
	public static final int SUIT_CLUB = 3;
	//ハートを表す静的定数を設定
	public static final int SUIT_HEART = 4;

	//スートを表すフィールドを宣言
	private int suitPattern = 0;
	//カードの数字を表すフィールドを宣言
	private int cardNumber = 0;

	/* 
	 * コンストラクタ名 Card
	 * 概要 スートと数字を初期化する
	 * 引数 スート、数字(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public Card(int suitPattern, int cardNumber) {
		//スートの柄を初期化
		this.suitPattern = suitPattern;
		//カードの数字を初期化
		this.cardNumber = cardNumber;
	}

	/* 
	 * 関数名 getNumber
	 * 概要 数字を取得する
	 * 引数 なし
	 * 返り値 カードの数字(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public int getNumber() {
		//カードの数字を返却
		return cardNumber;
	}

	/* 
	 * 関数名 getSuit
	 * 概要 スートを取得する
	 * 引数 なし
	 * 返り値 スート(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public int getSuit() {
		//スートの柄を返却する
		return suitPattern;
	}

	/* 
	 * 関数名 toString
	 * 概要 カードのスートと数字を表示する
	 * 引数 なし
	 * 返り値 スートと数字を表す文字列(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public String toString() {
		//StringBufferクラスを初期化
		StringBuffer string = new StringBuffer();

		//数字が正の数の場合
		if (cardNumber > 0) {
			//スートによって分岐
			switch (suitPattern) {
			//スペードの場合
			case SUIT_SPADE:
				//スペードを表す文字を表示
				string.append("S");
				//分岐を終了
				break;
			//ダイヤの場合
			case SUIT_DIAMOND:
				//ダイヤを表す文字を表示
				string.append("D");
				//分岐を終了
				break;
			//クラブの場合
			case SUIT_CLUB:
				//クラブを表す文字を表示
				string.append("C");
				//分岐を終了
				break;
			//ハートの場合
			case SUIT_HEART:
				//ハートを表す文字を表示
				string.append("H");
				//分岐を終了
				break;
			//それ以外の場合
			default:
				//分岐を終了
				break;
			}

			//エースを表す定数を設定
			final int CARD_ACE = 1;
			//10を表す定数を設定
			final int CARD_TEN = 10;
			//ジャックを表す定数を設定
			final int CARD_JACK = 11;
			//クイーンを表す定数を設定
			final int CARD_QUEEN = 12;
			//キングを表す定数を設定
			final int CARD_KING = 13;

			//数字によって分岐
			switch (cardNumber) {
			//エースの場合
			case CARD_ACE:
				//エースを表す文字を表示
				string.append("A");
				//分岐を終了
				break;
			//10の場合
			case CARD_TEN:
				//10を表す文字を表示
				string.append("T");
				//分岐を終了
				break;
			//ジャックの場合
			case CARD_JACK:
				//ジャックを表す文字を表示
				string.append("J");
				//分岐を終了
				break;
			//クイーンの場合
			case CARD_QUEEN:
				//クイーンを表す文字を表示
				string.append("Q");
				//分岐を終了
				break;
			//キングの場合
			case CARD_KING:
				//キングを表す文字を表示
				string.append("K");
				//分岐を終了
				break;
			//それ以外の場合
			default:
				//分岐を終了
				break;
			}
			//ジョーカーの場合
		} else {
			//ジョーカーを表す文字を表示
			string.append("JK");
		}
		//スートと数字を表す文字列を返却
		return string.toString();
	}

}
