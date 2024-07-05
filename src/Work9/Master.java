package Work9;
//ArrayListクラスをインポート
import java.util.ArrayList;

/* 
 * クラス名 Master
 * 概要 進行役の情報を管理する
 * 作成者 Y.Saeki
 * 作成日 2024/07/03
 */
public class Master {
	//ゲームの参加者を表すリストを作成
	private ArrayList<Player>joinPlayers = new ArrayList<Player>();
	
	/* 
	 * 関数名 prepareGame
	 * 概要 参加者にカードを配る
	 * 引数 山札(Hand)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void prepareGame(Hand deckCards) {
		//カード配布を宣告
		System.out.println("【カードを配ります】");
		//山札をシャッフルする
		deckCards.shuffleCard();
		//山札の枚数を数える
		int numberOfCards = deckCards.getNumberOfCards();
		//参加者の人数を数える
		int numberOfPlayers = joinPlayers.size();
		//山札の全てのカードを参加者に均等に配布する
		for ( int index = 0; index < numberOfCards; index++) {
			//配るカードを表す変数を設定し、山札の先頭のカードを代入
			Card givingCard = deckCards.pickCard(0);
			//カードを配られるプレイヤーを表す変数を、その配布回毎に設定
			Player recievePlayer = (Player)joinPlayers.get(index % numberOfPlayers);
			//配られるプレイヤーの手札にカードを追加する
			recievePlayer.receiveCard(givingCard);
		}
	}
	/* 
	 * 関数名 startGame
	 * 概要 ゲームを開始する
	 * 引数 なし
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void startGame() {
		//ゲーム開始を宣告
		System.out.println("\n【ゲームを開始します】");
		//次の手番のプレイヤーを求めるために使用する定数を設定
		final int NEXT_PLAYER = 1;
		
		//プレイヤーの人数を取得し、最後の1名になるまでゲームを進行する
		for ( int count = 0; joinPlayers.size() > 1; count++) {
			//手番のプレイヤーを表す変数を設定し、参加者リストとゲームのターム数を用いて代入
			int playerIndex = count % joinPlayers.size();
			//次の手番のプレイヤーを表す変数を設定し、参加者リストとゲームのターム数を用いて代入
			int nextPlayerIndex = (count + NEXT_PLAYER) % joinPlayers.size();
			//現在の手番のプレイヤーを取得
			Player turnPlayer = (Player)joinPlayers.get(playerIndex);
			//次の手番のプレイヤーを取得
			Player nextTurnPlayer = (Player)joinPlayers.get(nextPlayerIndex);
			//手番のプレイヤーを表示
			System.out.println("\n" + turnPlayer + "さんの番です。");
			//手番のプレイヤーが操作を行う。
			turnPlayer.playGame(nextTurnPlayer);
		}//参加者が1名になった場合、ゲームを終了する
		System.out.println("【ゲームを終了しました】");
	}
	
	
	/* 
	 * 関数名 decleareWin
	 * 概要 プレイヤーの上がりを宣言する
	 * 引数 上がったプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void decleareWin(Player winnerPlayer) {
		//上がったプレイヤーを表示
		System.out.println(" " + winnerPlayer + "さんが上がりました！\n");
		//上がったプレイヤーを参加者リストから外す。
		deregisterPlayer(winnerPlayer);
	}
	
	/* 
	 * 関数名 registerPlayer
	 * 概要 参加者のリストにプレイヤーを追加する
	 * 引数 追加するプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/04
	 */
	public void registerPlayer(Player joinPlayer) {
		//参加者のリストにプレイヤーを追加
		joinPlayers.add(joinPlayer);
	}
	/* 
	 * 関数名 deregisterPlayer
	 * 概要 プレイヤーを参加者リストから削除する
	 * 引数 削除するプレイヤー(Player)
	 * 返り値 なし
	 * 作成者 Y.Saeki
	 * 作成日 2024/07/03
	 */
	public void deregisterPlayer(Player registerPlayer) {
		//参加者リストから抹消したいプレイヤーを削除する
		joinPlayers.remove(joinPlayers.indexOf(registerPlayer));
		//最後の参加者であることを表す定数を設定
		final int LAST_MEMBER = 1;
		//参加者が最後の一人になった場合
		if (joinPlayers.size() == LAST_MEMBER) {
			//敗北したプレイヤーを表す変数を設定し、リストの最後の一人を入力
			Player losePlayer = (Player) joinPlayers.get(0);
			//敗北したプレイヤーを表示
			System.out.println(" " + losePlayer + "さんの負けです！");
		}
	}

	
	
	
	
	
	
	
	
}
