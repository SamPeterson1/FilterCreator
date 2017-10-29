
public class MusicStaff {
	int[][] data = new int[10][10];
	int size = 10;
	int creationNum = 1;
	boolean revive = true;
	public void toggleNote(int x, int y) {
		if(this.data[y][x] == 1) {
			this.data[y][x] = 0;
		} else {
			this.data[y][x] = 1;
		}
	}
	public int getNote(int x, int y) {
		return this.data[y][x];
	}
	public void decreaseSize() {
		this.size --;
	}
	public void increaseSize() {
		this.size ++;
	}
	public void toggleDissapate(int x, int y) {
		if(this.data[y][x] == 2) {
			this.data[y][x] = 0;
		} else {
			this.data[y][x] = 2;
		}
	}
	public void toggleAnyCell(int x, int y) {
		if(this.data[y][x] == 3) {
			this.data[y][x] = 0;
		} else {
			this.data[y][x] = 3;
		}
	}
	public boolean isRevive() {
		return this.revive;
	}
	public void toggleMode() {
		if(revive) {
			revive = false;
		} else {
			revive = true;
		}
	}
	public String print() {
		StringBuilder sb = new StringBuilder("");
		//loaf, 2, 1, GOLBoard.REVIVE, board
		sb.append("int[][] pattern").append(creationNum).append(" = {");
		for(int i = 0; i < size; i ++) {
			sb.append("{");
			for(int j = 0; j < size; j ++) {
				if(j < size - 1 & this.getNote(j, i) != 2) {
					sb.append(this.getNote(j, i)).append(",");
				} else if(this.getNote(j, i) != 2){
					sb.append(this.getNote(j, i));
				} else if(j < size - 1){
					if(!revive) {
						sb.append(this.getNote(j, i) - 1).append(",");
					} else {
						sb.append(this.getNote(j, i) - 2).append(",");
					}
				} else {
					if(!revive) {
						sb.append(this.getNote(j, i) - 1);
					} else {
						sb.append(this.getNote(j, i) - 2);
					}
				}
			}
			if(i < size - 1) {
				sb.append("},");
			} else {
				sb.append("}");
			}
		}
		sb.append("};").append("\n");
		sb.append("PatternFilter filter").append(creationNum).append(" = new PatternFilter(");
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++) {
				if(this.getNote(j, i) == 2) {
					sb.append("pattern").append(creationNum).append(", ").append(i).append(", ").append(j).append(", ");
				}
			}
		}
		if(revive) {
			sb.append("GOLBoard.REVIVE, ");
		} else {
			sb.append("GOLBoard.KILL, ");
		}
		sb.append("Board");
		sb.append(");").append("\n").append("filters.add(filter").append(creationNum).append(");");
		creationNum ++;
		return sb.toString();
	}
}
