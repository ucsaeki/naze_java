package Work6;

public class Player {
	//信仰者を生成
	private Master gameMaster;
	//
	private Table tables;

	private Hand myHand = new Hand();

	private String myname;

	/* 
	 * コンストラクタ名 Player
	 * 概要 プレイヤーの名前、進行役、テーブルを初期化する
	 * 引数 プレイヤーの名前(String)、進行役(Master)、テーブル(Table)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public Player(String yourname, Master master, Table table) {

		//名前を表すフィールドを引数で初期化
		this.myname = yourname;
		//進行役を表すフィールドを引数で初期化
		this.Master = master;
		//テーブルを表すフィールドを引数で初期化
		this.tables = table;
	}

	/* 
	 * 関数名 playGame
	 * 概要 相手からカードを引き、重複があれば捨て、手札が0枚になったら上がる。
	 * 引数 プレイヤーの情報(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/02
	 */
	public void playGame(Player nextPlayer) {
		//次の人の手を確認する
		Hand nextHand = nextPlayer.showHand();
		//次の人からカードを引く。
		Card pickdeCard = nextHand.pickCard();
		//次の人から引いたカードを表示
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
		//引いたカードを手札に加え、被りのカードがあれば捨てる
		dealCard(pickdeCard);
		//手札が0枚の場合
		if (myHand.getNumberOfCards() == 0) {
			//進行役に上がりを宣言
			master.decleareWin(this);
			//手札が存在する場合
		} else {
			//残りの手札をすべて表示する。
			System.out.println(this + "：残りの手札は" + myHand + "です。");
		}

	}
}
