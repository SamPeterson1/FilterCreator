
public class CMain {
	public static void main(String[] args) {
		CFrame frame = new CFrame();
		CCanvas canvas = new CCanvas();
		CEventQueue queue = new CEventQueue();
		CEvent event;
		MusicStaff staff = new MusicStaff();
		canvas.addEventQueue(queue);
		frame.addCanvas(canvas);
		canvas.setStaff(staff);
		while(true) {
			if(queue.isEventToProcess()) {
				event = queue.getEvent();
				if(event.getType() == CEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseLeftButton()) {
					int x = event.getMouseX();
					int y = event.getMouseY();
					if(x >= 200 & x < 400 & y >= 550 & y <= 750 ){
						String i = staff.print();
						System.out.println(i);
					} else if(x >= 500 & x <= 700 & y >= 600 & y <= 660) {
						staff.toggleMode();
					} else if(x / 50 <= staff.size - 1 & x / 50 >= 0 & y / 50 >= 0 & y / 50 <= staff.size - 1){
						staff.toggleNote(x / 50, y / 50);
					}
				} else if(event.getType() == CEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseRightButton()) {
					int x = event.getMouseX();
					int y = event.getMouseY();
					if(x / 50 <= staff.size - 1 & x / 50 >= 0 & y / 50 >= 0 & y / 50 <= staff.size - 1){
						staff.toggleDissapate(x / 50, y / 50);
					}
				} else if(event.getType() == CEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseMiddleButton()) {
					int x = event.getMouseX();
					int y = event.getMouseY();
					if(x / 50 <= staff.size - 1 & x / 50 >= 0 & y / 50 >= 0 & y / 50 <= staff.size - 1){
						staff.toggleAnyCell(x / 50, y / 50);
					}
				} else if(event.getType() == CEvent.EVENT_KEY_PRESS) {
					if(event.getKeyChar() == 'u') {
						staff.decreaseSize();
					} else {
						staff.increaseSize();
					}
				}
			}
			//500, 600, 200, 60
			canvas.draw();
		}
	}
	/*


	 */
}
