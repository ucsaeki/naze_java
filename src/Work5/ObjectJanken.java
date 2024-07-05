package Work5;

/* 
 * クラス名 ObjectJanken
 * 概要 二人のプレイヤーでジャンケンを行う
 * 作成者 Y.Saeki
 * 作成日 2024/07/01
 */
public class ObjectJanken {
	/* 
	 * 関数名 main
	 * 概要 二人のプレイヤーでジャンケンを行う
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/01
	 */
	public static void main(String[] args) {
		//審判を表すインスタンスを作成
		Judge judgeSaito = new Judge();
		//プレイヤー1を表すインスタンスを作成
		Player player1Murata = new MurataEx("村田さん");
		//プレイヤー2を表すインスタンスを作成
		Player player2Yamada = new YamadaEx("山田さん");
		//プレイヤー1の戦略を生成
		Tactics murataTactics = new CyclicTactics();
		//グーチョキパー戦略をプレイヤー1のインスタンスに設定
		player1Murata.setTactics(murataTactics);
		//プレイヤー2の戦略を生成
		Tactics yamadaTactics = new RandomTactics();
		//ランダム戦略をプレイヤー2のインスタンスに設定
		player2Yamada.setTactics(yamadaTactics);
		
		//プレイヤー二人でジャンケンを行う。
		judgeSaito.startJanken(player1Murata, player2Yamada);
	}

}
