class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int[][][]keys=new int[4][key.length][key.length];
        keys=getKey(key);
        return checkKey(keys,lock);
    }
	public boolean checkKey(int[][][] keys,int[][] lock) {
		boolean isOK=true;
		int[][] newMap=new int[keys[0].length*2+lock.length-2][keys[0].length*2+lock.length-2];
		for(int i=keys[0].length-1;i<keys[0].length+lock.length-1;++i) {
			for(int j=keys[0].length-1;j<keys[0].length+lock.length-1;++j) {
				newMap[i][j]=lock[i-keys[0].length+1][j-keys[0].length+1];
			}
		}
		for(int t=0;t<4;++t) {
			for(int i=0;i<keys[t].length+lock.length-1;++i) {
				for(int j=0;j<keys[t].length+lock.length-1;++j) {
					boolean isPossible=true;
					for(int k=0;k<keys[t].length;++k) {
						for(int l=0;l<keys[t].length;++l) {
							newMap[k+i][l+j]+=keys[t][k][l];
						}
					}
					check :
					for(int k=keys[t].length-1;k<keys[t].length+lock.length-1;++k) {
						for(int l=keys[t].length-1;l<keys[t].length+lock.length-1;++l) {
							if(newMap[k][l]!=1) {
								isPossible=false;
								break check;
							}
						}
					}
					if(isPossible) return true;
					for(int k=0;k<keys[t].length;++k) {
						for(int l=0;l<keys[t].length;++l) {
							newMap[k+i][l+j]-=keys[t][k][l];
						}
					}
				}
			}
		}
		return false;
	}
	public int[][][] getKey(int[][]key) {
		int[][][]keys=new int[4][key.length][key.length];
		for(int i=0;i<key.length;++i) {
			for(int j=0;j<key.length;++j) {
				keys[0][i][j]=key[i][j];
				keys[1][key.length-j-1][i]=key[i][j];
				keys[2][key.length-i-1][key.length-j-1]=key[i][j];
				keys[3][j][key.length-i-1]=key[i][j];
			}
		}
		return keys;
	}
}