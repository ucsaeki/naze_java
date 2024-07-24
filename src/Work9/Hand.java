package Work9;

//AllayListクラスをインポート
import java.util.ArrayList;

/* 
 * クラス名 Hand
 * 概要 手札を管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public class Hand {
	//手札を表すリストを作成
	private ArrayList<Card> handCard = new ArrayList<Card>();

	/* 
	 * 関数名 addCard
	 * 概要 手札にカードを加える
	 * 引数 カード(Card)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public void addCard(Card variableCard) {
		//手札のリストにカードを加える
		handCard.add(variableCard);
	}

	/* 
	 * 関数名 lookCard
	 * 概要 手札のカードを見る
	 * 引数 見たいカードの位置(int)
	 * 返り値 その位置にあるカード(Card)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card lookCard(int handPosition) {
		//見るカードを表す変数の初期値にnullを設定
		Card lookingCard = null;
		//位置を指定する引数が0以上かつ、手札の枚数を越えない場合
		if ((0 <= handPosition) && (handPosition < handCard.size())) {
			//見るカードを表す変数に手札の指定された位置のカードを代入
			lookingCard = (Card) handCard.get(handPosition);
		} //カードを返却
		return lookingCard;
	}

	/* 
	 * 関数名 pickCard
	 * 概要 手札のカードを引く
	 * 引数 引きたいカードの位置(int)
	 * 返り値 その位置にあるカード(Card)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card pickCard(int handPosition) {
		//引くカードを表す変数の初期値にnullを設定
		Card pickCard = null;
		//位置を指定する引数が0以上かつ、手札の枚数を越えない場合
		if ((0 <= handPosition) && (handPosition < handCard.size())) {
			//見るカードを表す変数に手札の指定された位置のカードを代入
			pickCard = (Card) handCard.remove(handPosition);
		} //カードを返却
		return pickCard;
	}

	/* 
	 * 関数名 shuffleCard
	 * 概要 手札をシャッフルする
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void shuffleCard() {

		//カードの枚数を表す変数を設定し、枚数を入力する
		int numberOfCards = handCard.size();
		//カードを抜く位置を表す変数を設定
		int posCard = 0;
		//シャッフルの回数を増やすために使用する定数を設定
		final int SHUFFLE_NUMBER = 2;
		//カードをシャッフルする
		for (int count = 0; count < numberOfCards * SHUFFLE_NUMBER; count++) {
			//ランダムな位置を設定
			posCard = (int) (Math.random() * numberOfCards);
			//設定した位置からカードを一枚抜く
			Card pickedCard = (Card) handCard.remove(posCard);
			//抜いたカードを手札の最後に加える
			handCard.add(pickedCard);
		}
	}
	
	/* 
	 * 関数名 getNumberOfCards
	 * 概要 手札の枚数を数える
	 * 引数 なし
	 * 返り値 手札の枚数(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public int getNumberOfCards() {
		//手札の枚数を返却する
		return handCard.size();
	}
	/* 
	 * 関数名 toString
	 * 概要 手札を文字列で表す
	 * 引数 なし
	 * 返り値 手札を表す文字列(String9
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public String toString() {
		//StringBufferクラスに初期値を設定
		StringBuffer stringBuffer = new StringBuffer();
		//手札の枚数を表す変数を設定
		int handSize = handCard.size();
		//手札がある場合
		if(handSize > 0) {
			//全ての手札を表示するまで繰り返す
			for ( int index = 0; index < handSize; index++) {
				//カードを表す変数にリスト内のカードを代入
				Card variableCard = (Card) handCard.get(index);
				//カードを表示
				stringBuffer.append(variableCard);
				//調整のための空白を表示
				stringBuffer.append(" ");
			}
		}
		//手札を表す文字列を返却する
		return stringBuffer.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
