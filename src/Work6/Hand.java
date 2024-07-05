package Work6;
//ArrayListクラスをインポート
import java.util.ArrayList;
/* 
 * クラス名 Hand
 * 概要 手札を管理するクラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/02
 */
public class Hand {
	//手札を表す配列を作成
	private ArrayList handCard = new ArrayList();
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
	 * 関数名 pickCard
	 * 概要 カードを引く
	 * 引数 なし
	 * 返り値 引いたカード(Card)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public Card pickCard() {
		//引いたカードを表す変数に手札の一番先頭のカードを代入
		Card pickedCard = (Card) handCard.remove(0);
		//引いたカードを返却
		return pickedCard;
	}
	/* 
	 * 関数名 shuffleCard
	 * 概要 カードをシャッフルする
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public void shuffleCard() {
		//カードの枚数を表す変数を設定し、枚数を入力する
		int numberOfCards = handCard.size();
		//カードを抜く位置を表す変数を設定
		int posCard = 0;
		//カードをシャフルする
		for(int count = 0; count < numberOfCards * 2; count++ ) {
			//ランダムな位置を設定
			posCard = (int) (Math.random() * numberOfCards);
			//設定した位置からカードを一枚抜く
			Card pickedCard = (Card) handCard.remove(posCard);
			//抜いたカードを手札に加える
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
	 * 関数名 findSameNumberCards
	 * 概要 同じ数のカードを探す
	 * 引数 なし
	 * 返り値 同じ数のカードの組み合わせ(Card[])、もしくは同じカードなし(null)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public Card[] findSameNumberCards() {
		//手札の枚数を数える。
		int numberOfCards = handCard.size();
		//同じ数字のカードを格納するための配列を作成
		Card[] sameCards = null;
		//カードを持つ場合
		if(numberOfCards > 0) {
			//最後に追加されたカードのインデックスの値を取得
			int lastIndex = numberOfCards -1;
			//最後に追加されたカードを取得
			Card lastAddedCard = (Card) handCard.get(lastIndex);
			//最後に追加されたカードの数字を取得
			int lastAddedCardNumber = lastAddedCard.getNumber();
			//手札の全てのカードから、最後に追加されたカードと同じ数字のカードを探す
			for (int index = 0; index < lastIndex; index++) {
				//手札のカードを表す変数にカードを代入
				Card card = (Card) handCard.get(index);
				//カードの数字が最後に追加されたカードと同じだった場合
				if(card.getNumber() == lastAddedCardNumber) {
					//同じ数字のカードを格納する配列を生成
					sameCards = new Card[2];
					//配列に最後に追加されたカードを挿入
					sameCards[0] = (Card) handCard.remove(lastIndex);
					//配列に同じ数字のカードを挿入
					sameCards[1] = (Card) handCard.remove(index);
					//繰り返しを終了する。
					break;
				}
			}
		}//同じカードを持つ配列を返却
		return sameCards;
		
	}
	/* 
	 * 関数名 toString
	 * 概要 手札を表す文字列を返却する
	 * 引数 なし
	 * 返り値 手札を表す文字列(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public String toString() {
		//StringBufferクラスを初期化
		StringBuffer string = new StringBuffer();
		//手札の枚数を取得
		int size = handCard.size();
		//手札が存在する場合
		if(size > 0) {
			//手札の全てを表示するまで繰り返す
			for(int index = 0; index < size; index++) {
				//手札のカードを表す変数を設定
				Card card = (Card) handCard.get(index);
				//カードを表示する
				string.append(card);
				//空白を表示する
				string.append(" ");
			}
		}//文字列を返却
		return string.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
