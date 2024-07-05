package Work6;

import java.util.ArrayList;

/* 
 * クラス名 Table
 * 概要 テーブルの情報を管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/02
 */
public class Table {
	//捨て札を格納するための配列を表すフィールドを宣言
	private ArrayList disposedCards = new ArrayList();
	/* 
	 * 関数名 disposeCard
	 * 概要 カードを捨てる
	 * 引数 捨てられたカードの組(Card[])
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public void disposeCard(Card variableCard[]) {
		//捨てられた札を全て捨てる
		for (int index = 0; index < variableCard.length; index++) {
			//捨てたカードを表示
			System.out.print(variableCard[index] + " ");
			//カードを捨てたことを表示
			System.out.println("を捨てました");
		}
		//捨てられたカードを配列に格納する
		disposedCards.add(variableCard);
		
		
	}

}
