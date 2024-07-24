package fantan;

//Cardクラスをインポート
import Work9.Card;
//Handクラスをインポート
import Work9.Hand;
//Ruleクラスをインポート
import Work9.Rule;
//Tableクラスをインポート
import Work9.Table;

/* 
 * クラス名 FantanRule
 * 概要 七並べルールを管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public class FantanRule implements Rule {

	/* 
	 * 関数名 findCandidate
	 * 概要 手札とテーブルを確認して置けるカードを探す
	 * 引数 手札(Hand)、テーブル(Table)
	 * 返り値 置けるカードの組み合わせ(Card[])、もしくは置けるカードがない(null)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Card[] findCandidate(Hand variableHand, Table variableTable) {
		//テーブルにおける手札の候補のカードを表す変数を設定し、初期値にnullを代入
		Card[] candidateCard = null;
		//手札の枚数を取得する
		int numberOfhHand = variableHand.getNumberOfCards();

		//エースを表す定数を設定
		final int ACE_CARD = 1;
		//一つ隣のカードを表すための定数を設定
		final int BESIDE_CARD = 1;
		//配列の要素数を表す定数を設定
		final int ELEMENT_COUNT = 1;

		//全ての手札を走査し、置けるカードがあるか調べる
		for (int i = 0; i < numberOfhHand; i++) {
			//見る対象のカードを表す変数を設定し、そのカードを代入する
			Card lookingCard = variableHand.lookCard(i);
			//カードのスートを表す変数を設定し、取得したスートを代入
			int lookingCardSuit = lookingCard.getSuit();
			//カードの数字を表す変数を設定し、取得した数字を代入
			int lookingCardNumber = lookingCard.getNumber();
			//一つ左の数字を表す変数を設定し、左にいける場合その数字を、いけない場合そのままの数字を代入。
			int leftNextCardNumber =(lookingCardNumber != BESIDE_CARD) ? lookingCardNumber - BESIDE_CARD : Card.CARD_NUMBER;
			//一つ右の数字を表す変数を設置し、右にいける場合その数字を、いけない場合接続するエースを代入。
			int rightNextCardNumber = (lookingCardNumber != Card.CARD_NUMBER) ? lookingCardNumber + BESIDE_CARD : ACE_CARD;
			//手札のカードを置ける場所がある場合
			if ((isThereCard(variableTable, lookingCardSuit, leftNextCardNumber) == true)
					|| (isThereCard(variableTable, lookingCardSuit, rightNextCardNumber) == true)){
				//候補のカードを格納する配列に要素数を設定
				candidateCard = new Card[ELEMENT_COUNT];
				//配列に手札の候補のカードを入力
				candidateCard[0] = variableHand.pickCard(i);
				//繰り返しを終了
				break;
			}
		}
		//置けるカードの探索の結果を返却する
		return candidateCard;
	}
	/* 
	 * 関数名 isThereCard
	 * 概要 候補のカードを置くことができるかどうかを判定する
	 * 引数 置くテーブル(Table)、候補のカードのスート、数字(int)
	 * 返り値 置けるかどうか(true, false)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	private boolean isThereCard(Table cardTable, int cardSuit, int cardNumber) {
		//カードを置けるかどうかを判断する変数を設定し、初期値に置けない状態を入力
		boolean canPutCard = false;
		//インデックスの値のずれを修正するための定数を設定
		final int ADJUST_INDEX = -1;
		//テーブルの状況を取得
		Card[][] copyCards = cardTable.getCards();
		//対象のカードの位置に他のカードがない場合
		if (copyCards[cardSuit + ADJUST_INDEX][cardNumber + ADJUST_INDEX] != null) {
			//カードを置くことができると判定
			canPutCard = true;
		} //結果を返却
		return canPutCard;
	}

}
