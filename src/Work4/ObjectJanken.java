package Work4;

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
		Murata player1Murata = new Murata("村田さん");
		//プレイヤー2を表すインスタンスを作成
		Yamada player2Yamada = new Yamada("山田さん");
		//プレイヤー二人でジャンケンを行う。
		//startJankenメソッドはPlayerクラスを引数に取る関数なので、MurataとYamadaクラスには対応していない
		judgeSaito.startJanken(player1Murata, player2Yamada);
	}

}
