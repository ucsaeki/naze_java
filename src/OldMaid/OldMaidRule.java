package OldMaid;

//Cardクラスをインポート
import Work9.Card;
//Handクラスをインポート
import Work9.Hand;
//Ruleクラスをインポート
import Work9.Rule;
//Tableクラスをインポート
import Work9.Table;

/* 
 * クラス名 OldMaidRule
 * 概要 ババ抜きのルールを管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/04
 */
public class OldMaidRule implements Rule {
	/* 
	 * 関数名 findCandidate
	 * 概要 手札を確認して同じ数字のカードを探す
	 * 引数 手札(Hand)、テーブル(Table)
	 * 返り値 同じカードの組み合わせ(Card[])、もしくは同じカードがない(null)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public Card[] findCandidate(Hand variableHand, Table variableTable) {
		//インデックスの値のずれを修正するための定数を設定
		final int ADJUST_INDEX = 1;
		//同じ数字のカードを格納する配列を生成
		Card[] sameCards = null;
		//最後の手札の位置を表す変数を設定
		int lastIndex = variableHand.getNumberOfCards() - ADJUST_INDEX;
		//最後に追加されたカードを取得
		Card lastAddedCard = variableHand.pickCard(lastIndex);
		//最後に追加されたカードの数字を取得
		int lastAddedNumber = lastAddedCard.getNumber();
		//手札に同じ数字のカードがあるかどうか確認する
		for (int i = 0; i < variableHand.getNumberOfCards(); i++) {
			//手札のカードを表す変数を設定する
			Card targetCard = variableHand.lookCard(i);
			//同じ数字のカードが存在した場合
			if (targetCard.getNumber() == lastAddedNumber) {
				//目的のカードを引く
				targetCard = variableHand.pickCard(i);
				//同じ数字のカードを格納する配列に同じ数字のカードを格納
				sameCards = new Card[] { lastAddedCard, targetCard };
				//繰り返しを終了
				break;
			}
		}
		return sameCards;
	}
}
