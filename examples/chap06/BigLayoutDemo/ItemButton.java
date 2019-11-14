import javax.swing.JButton;

/** A JButton with an associated Item object.
 * @author mvail
 */
public class ItemButton extends JButton {
	private Item item;
	
	public ItemButton(Item item) {
		this.item = item;
		this.setText(item.toString());
	}

	public Item getItem() {
		return item;
	}
}
