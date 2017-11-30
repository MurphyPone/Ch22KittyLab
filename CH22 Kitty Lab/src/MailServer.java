import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class MailServer extends LinkedList<Message> {
	//Tree Set actor
	TreeSet<Actor> registeredSubscribers;
	
	MailServer() {
		registeredSubscribers = new TreeSet<Actor>();
	}
	
	public void signUp(Actor actor) {
		if(!registeredSubscribers.contains(actor))
			registeredSubscribers.add(actor);
	}
	
	public void dispatch(Message msg) {
		if(msg.getRecipient() == null) {
			for(Actor a : registeredSubscribers)
				a.recieve(msg);
		} else {
			Actor a = msg.getRecipient();
			a.recieve(msg);
		}
	}
}
