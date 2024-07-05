package Work5;

//BufferedReaderクラスをインポート
import java.io.BufferedReader;
//InputStreamReaderクラスをインポート
import java.io.InputStreamReader;

/* 
 * クラス名 AskTactics
 * 概要 手を入力可能にするTacticsインタフェースの実装クラス
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class AskTactics implements Tactics {
	/* 
	 * 関数名 readTactics
	 * 概要 手を入力して選択する
	 * 引数 なし
	 * 返り値 選ばれた手(int)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public int readTactics() {
		//
		BufferedReader BufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//手の入力を促す
		System.out.println("\nジャンケンの手を入力してください。");
		//グーの番号を表示
		System.out.println("0: グー");
		//チョキの番号を表示
		System.out.println("1: チョキ");
		//パーの番号を表示
		System.out.println("2: パー\n");
		//クエスチョンマークを表示
		System.out.println("? ");
		//選択された手を表す変数を設定
		int selectedHand = 0;
		//trueの間くりかえす
		while (true) {
			//入力の例外をチェックする
			try {
				//入力を読み込む
				String inputString = BufferedReader.readLine();
				//手を表す変数に入力を読み込む
				selectedHand = Integer.parseInt(inputString);
				//正しい手の値が入力された場合
				if (selectedHand == Player.STONE_HAND
						|| selectedHand == Player.SCISSORS_HAND
						|| selectedHand == Player.PAPER_HAND) {
					//繰り返しを終了する
					break;
					//入力された値が正しくない場合
				} else {
					//再度入力を求めるエラー文を表示
					System.out.println("入力が正しくありません。再度入力してください。");
					//クエスチョンマークを表示
					System.out.println("? ");
				}
				//例外が発生した場合に表示する
			} catch (Exception ex) {
				//再度入力を求めるエラー文を表示
				System.out.println("入力が正しくありません。再度入力してください。");
				//クエスチョンマークを表示
				System.out.println("? ");
			}
		}
		//入力された手を返却
		return selectedHand;
	}

}
