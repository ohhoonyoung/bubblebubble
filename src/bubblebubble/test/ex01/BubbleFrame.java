package bubblebubble.test.ex01;

import javax.swing.JFrame;

// 1. ������ â�� �Ǿ���
// 2. ������ â�� ���ο� �г��� �ϳ� ������ �ִ�
public class BubbleFrame extends JFrame{
	
	public BubbleFrame() {
		setSize(1000, 640);
		setVisible(true); // �׸��� �׷���
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}

}
