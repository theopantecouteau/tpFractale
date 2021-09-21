import java.util.ArrayList;

class DessinFractale{
    private final Turtle bob;
    
    private final static int LARGEUR = 800;
    private final static int HAUTEUR = 600;
    //taille de la fenetre graphique

    public DessinFractale(){
	bob  = new Turtle();
	Turtle.setCanvasSize(LARGEUR,HAUTEUR);//à appeler APRES création de la tortue
    }

    public DessinFractale(int v){
	//attention, plus v est grand, plus bob va lentement !
	this();
	bob.speed(v);
    }


    public void reset(){
	bob.clear();
	bob.up();
	bob.setPosition(0,0);
	bob.setDirection(0);
	bob.down();

    }

    public void close(){
	bob.exit();
    }


    public void carre(double l){ //trace un carré vers la droite de bob
		bob.right(0);
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
		bob.forward(l);
		bob.left(90);
    }

    public void vonKoch(double l, int n){
		bob.speed(1);
    	if (n==0) {
			bob.forward(l);
		}
    	else{
			vonKoch(l/3, n - 1);
			bob.left(60);
			vonKoch(l/3, n-1);
			bob.right(120);
			vonKoch(l/3, n-1);
			bob.left(60);
			vonKoch(l/3, n-1);

		}
	}

	public void drawTree (int n, int l){

    	if(n==0) {
			bob.forward(l);
		}
    	else {
			drawTree(n - 1, l);
			bob.left(30);
			drawTree(n - 1, l/3);
			bob.forward(-l/3);
			bob.right(60);
			drawTree(n - 1, l/3);
			bob.forward(-l/3);
			bob.left(30);
			drawTree(n-1, l/3);
			bob.forward(-l/3);
		}

    }

	public void trieForce (int n, int l) {
    	bob.speed(100);
    	if (n==0){
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
			bob.forward(l);
			bob.left(120);
		}
    	else{
    		trieForce(n-1, l/2);
    		bob.forward(l/2);
    		trieForce(n-1,l/2);
    		bob.left(120);
			bob.forward(l/2);
			bob.right(120);
			trieForce(n-1, l/2);
			bob.right(120);
			bob.forward(l/2);
			bob.left(120);
		}
	}


	public void dragon (int n , int l, int x){
    	if (n==0){
    		bob.forward(100);
		}
    	else if(x==0){
    		dragon(n-1,l, 0);
    		bob.left(90);
    		dragon(n-1, l, 1);
		}
    	else{
			dragon(n-1,l, 0);
			bob.right(90);
			dragon(n-1, l, 1);
		}


	}

	public static void main(String[] args) {
    	DessinFractale d = new DessinFractale(500);
	/*d.carre(90);
	d.reset();
	d.carre(60);
	d.reset();
	d.vonKoch(1000, 5);
	d.close();
	d.drawTree(3, 100);

	d.trieForce(2, 100);*/
		d.dragon(4,100,0);
	}
    
}