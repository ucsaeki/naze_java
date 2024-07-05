package Work9;

/* 
 * クラス名 Player
 * 概要 プレイヤーの情報を管理するクラスを設定
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public abstract class Player {
	//プレイヤー名を表すフィールドを設定
	protected String playerName = ("");
	//テーブルを表すフィールドを設定
	protected Table cardTable;
	//手札を表すフィールドを設定
	protected Hand myHand = new Hand();
	//進行役を表すフィールドを設定
	protected Master myMaster;
	//ルールを表すフィールドを設定
	protected Rule myRule;

	/* 
	 * コンストラクタ名 Player
	 * 概要 名前、テーブル、手札、進行役、ルールでフィールドを初期化する。
	 * 引数 名前(String)、テーブル(Table)、進行役(Master)、ルール(Rule)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public Player(String playerName, Table cardTable, Master myMaster, Rule myRule) {
		//名前を表すフィールドに引数を代入
		this.playerName = playerName;
		//テーブルを表すフィールドに引数を代入
		this.cardTable = cardTable;
		//進行役を表すフィールドに引数を代入
		this.myMaster = myMaster;
		//ルールを表すフィールドに引数を代入
		this.myRule = myRule;
	}

	/* 
	 * 関数名 playGame
	 * 概要 ゲームを行い、次のプレイヤーを指名する
	 * 引数 次のプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public abstract void playGame(Player nextPlayer);

	/* 
	 * 関数名 reciveCard
	 * 概要 カードを手札に加える
	 * 引数 加えたいカード(Card)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void receiveCard(Card receivedCard) {
		//受けとったカードを手札の最後尾に追加する
		myHand.addCard(receivedCard);
	}

	/* 
	 * 関数名 toStiring
	 * 概要 プレイヤー名を表す文字列を表示する
	 * 引数 なし
	 * 返り値 プレイヤー名を表す文字列(String)
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public String toString() {
		//プレイヤー名を返却
		return playerName;
	}

}
