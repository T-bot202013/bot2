
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

	public class botserve extends HttpServlet{
		private static String consumerKey = "paAvtdCpmTFI0yCkGXwyDm15Z";
		private static String consumerSecret = "jAsrUiXbbx24DcPHFax1oJeCSw53DLzMqcc0lDbOaKBsdoJIhk";
		private static String accessToken = "1196226134209228800-nd5OLsaSgLNNhMotyODXsASEogcA46";
		private static String accessTokenSecret = "YREMOxLKU3iCcj3xeA4hyA5hzRzT95Y3M3wgxFG29sVwl";
		private String getTweet(){
			String tweets[] = {"準備中"};
			int randint = (int)(Math.random()*tweets.length);
			return tweets[randint];
		}

		public void main(HttpServletRequest req, HttpServletResponse resp)
				throws IOException{
			String message = getTweet();
			Twitter twitter = new TwitterFactory().getInstance();
			StatusUpdate update = new StatusUpdate(message);
			twitter.setOAuthConsumer(consumerKey, consumerSecret);
			twitter.setOAuthAccessToken(new AccessToken(accessToken,accessTokenSecret));
			try{
				File file = new File("画像ファイルのpath");
			      update.media(file);
				twitter.updateStatus(message);
				System.out.println("ツイート成功");
			} catch(TwitterException e){
				System.err.println("ツイート失敗"+e.getMessage());
			}
		}
	}

