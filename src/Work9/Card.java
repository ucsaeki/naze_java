package Work9;

/* 
 * クラス名 Card
 * 概要 カードの情報を管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public class Card {
	//スペードを表すクラス定数を設定
	public static final int SUIT_SPADE = 1;
	//ダイヤを表すクラス定数を設定
	public static final int SUIT_DIAMOND = 2;
	//クラブを表すクラス定数を設定
	public static final int SUIT_CLUB = 3;
	//ハートを表すクラス定数を設定
	public static final int SUIT_HEART = 4;
	//スートの種類数を表すクラス定数を宣言
	public static final int SUIT_NUMBER = 4;
	//数字の種類数を表すクラス定数を宣言
	public static final int CARD_NUMBER = 13;
	//スートを表すフィールドを宣言
	protected int cardSuit;
	//数字を表すフィールドを宣言
	protected int cardNumber;
	/* 
	 * コンストラクタ名 Card
	 * 概要 スートと数字を初期化する
	 * 引数 スート、数字(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card(int cardSuit, int cardNumber) {
		//スートを表すフィールドに引数を代入して初期化
		this.cardSuit = cardSuit;
		//数字を表すフィールドに引数を代入して初期化
		this.cardNumber = cardNumber;
	}
	/* 
	 * 関数名 getSuit
	 * 概要 スートを取得する
	 * 引数 なし
	 * 返り値 スート(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public int getSuit() {
		//スートを返却する
		return cardSuit;
	}
	/* 
	 * 関数名 getNumber
	 * 概要 数字を取得する
	 * 引数 なし
	 * 返り値 スート(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public int getNumber() {
		//数字を返却する
		return cardNumber;
	}
	/* 
	 * 関数名 toString
	 * 概要 スートと数字を一つの文字列で表す
	 * 引数 なし
	 * 返り値 スートと数字を表す文字列(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public String toString() {
		//StringBufferクラスに変数を設定
		StringBuffer stringBuffer = new StringBuffer();
		
		//スートによって分岐
		switch (cardSuit) {
		
		//スペードの場合
		case SUIT_SPADE:
			//スペードを表す文字を表示
			stringBuffer.append("S");
			//分岐を終了
			break;
		//ダイヤの場合
		case SUIT_DIAMOND:
			//ダイヤを表す文字を表示
			stringBuffer.append("D");
			//分岐を終了
			break;
		//クラブの場合
		case SUIT_CLUB:
			//クラブを表す文字を表示
			stringBuffer.append("C");
			//分岐を終了
			break;
		//ハートの場合
		case SUIT_HEART:
			//ハートを表す文字を表示
			stringBuffer.append("H");
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
		switch(cardNumber) {
		
		//エースの場合
		case CARD_ACE:
			//エースを表す文字を表示
			stringBuffer.append("A");
			//分岐を終了
			break;
		//10の場合
		case CARD_TEN:
			//10を表す文字を表示
			stringBuffer.append("T");
			//分岐を終了
			break;
		//ジャックの場合
		case CARD_JACK:
			//ジャックを表す文字を表示
			stringBuffer.append("J");
			//分岐を終了
			break;
		//クイーンの場合
		case CARD_QUEEN:
			//クイーンを表す文字を表示
			stringBuffer.append("Q");
			//分岐を終了
			break;
		//キングの場合
		case CARD_KING:
			//キングを表す文字を表示
			stringBuffer.append("K");
			//分岐を終了
			break;
		//それ以外の場合
		default:
			//カードの数字を表示
			stringBuffer.append(cardNumber);
			//分岐を終了
			break;
		}
		//スートと数字を表す文字列を返却
		return stringBuffer.toString();
		
	}
	
	
	
	
	
	
}
