import java.io.IOException;

public class CountInversions extends ReadFile{
	private int[] array;
	private int length;
	private int[] tmparray;
	private long count;

	public void setArray(int[] array) {
		this.array = array;
		this.length = this.array.length;
		this.tmparray = new int[this.length];
		doSort(0,length-1);
	}

	private void doSort(int lowerindex, int higherindex) {
		if(lowerindex<higherindex){
			int middle = lowerindex + ((higherindex-lowerindex)/2);
			doSort(lowerindex, middle);
			doSort(middle+1, higherindex);
			doMerge(lowerindex,middle,higherindex);
		}
	}

	private void doMerge(int lowerindex, int middle, int higherindex) {
		for(int i=lowerindex;i<=higherindex;i++){
			this.tmparray[i] = this.array[i];
		}

		int i=lowerindex, j=middle+1, k=lowerindex;

		while(i<=middle && j<=higherindex){
			if(this.tmparray[i]<this.tmparray[j]){
				this.array[k] = this.tmparray[i];
				i++;
			}
			else{
				this.array[k] = this.tmparray[j];
				j++;
				this.count += (middle+1)-i;
			}
			k++;
		}
		while(i<=middle){
			this.array[k] = this.tmparray[i];
			i++;
			k++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		CountInversions obj = new CountInversions();
		obj.getFile();
		obj.setUnsortedArray();
		obj.setArray(obj.unsortedArray);
		System.out.println(obj.count);
	}
}
