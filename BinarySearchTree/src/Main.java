import java.util.Scanner;
class binarySearchTreeProductNode{
	int barcodeNumber;
	int quantity;
	String productName;
	binarySearchTreeProductNode right;
	binarySearchTreeProductNode left;
	binarySearchTreeProductNode(int barcodeNumber,int quantity,String productName) {
		this.barcodeNumber=barcodeNumber;
		this.quantity=quantity;
		this.productName=productName;
		right=null;
		left=null;
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		binarySearchTreeProductNode root=null;
		root = Insert(root,20,12,"Dalin Şampuan");
		root = Insert(root,15,38,"Biskrem Bisküvi");
		root = Insert(root,42,5,"Söke Un");
		root = Insert(root,8,18,"Filiz Makarna");
		root = Insert(root,17,65,"Erikli Su");
		root = Insert(root,55,0,"Filtre Kahve");
		root = Insert(root,87,15,"Çaykur Çay");
		while (true) {
			System.out.println("*****MENU*****");
			String menu="1)Insert node\n"
					+"2)Increase the quantity\n"
					+"3)Decrease the quantity\n"
					+"4)Print in-order\n"
					+"5)Print post-order\n"
					+"6)Print pre-order";
			System.out.println(menu);
			System.out.println("***************");
			System.out.println("Please enter a choice:");
			int choice=scanner.nextInt();
			if (choice==1) {
				System.out.println("Enter barcode number:");
				int barcode_number1=scanner.nextInt();
				System.out.println("Enter quantity:");
				int quantity1=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter product name:");
				String product_name1=scanner.nextLine();
				root = Insert(root,barcode_number1,quantity1,product_name1);
			}
			else if (choice==2) {
				System.out.println("Enter barcode number:");
				int barcode_number2=scanner.nextInt();
				System.out.println("Enter increment amount:");
				int increment_amount=scanner.nextInt();
				increment(root,barcode_number2,increment_amount);
			}
			else if (choice==3) {
				System.out.println("Enter barcode number:");
				int barcode_number3=scanner.nextInt();
				System.out.println("Enter decrement amount:");
				int decrement_amount=scanner.nextInt();
				decrement(root,barcode_number3,decrement_amount);
			}
			else if (choice==4) {
				System.out.println("*****In-order*****");
				inorder(root);
			}
			else if (choice==5) {
				System.out.println("*****Post-order*****");
				postorder(root);
			}
			else if (choice==6) {
				System.out.println("*****Pre-oder*****");
				preorder(root);
			}
			else {
				System.out.println("Please enter a valid choice!");
			}
		}
	}
	public static binarySearchTreeProductNode Insert(binarySearchTreeProductNode pointer, int barcodeNumber, int quantity, String name){
	    if(pointer == null){
	        pointer = new binarySearchTreeProductNode(barcodeNumber, quantity, name);
	    }
	    else if(barcodeNumber<=pointer.barcodeNumber){
	        pointer.left = Insert(pointer.left, barcodeNumber, quantity, name);
	    }
	    else{
	        pointer.right = Insert(pointer.right, barcodeNumber,quantity, name);
	    }
	    return pointer;
	}
	public static void increment(binarySearchTreeProductNode pointer, int barcodeNumber, int quantity){
        if(pointer == null) {
            System.out.println("Tree is empty");
            return;
        }
        if(pointer.barcodeNumber == barcodeNumber){
            pointer.quantity += quantity;
        }

        else if(pointer.barcodeNumber>barcodeNumber){
            increment(pointer.left, barcodeNumber, quantity);
        }
        else {
            increment(pointer.right, barcodeNumber, quantity);
        }
    }
	public static void decrement(binarySearchTreeProductNode pointer, int barcodeNumber, int quantity){
        if(pointer == null) {
            System.out.println("Tree is empty");
            return;
        }
        if(pointer.barcodeNumber == barcodeNumber){
            pointer.quantity -= quantity;
        }

        else if(pointer.barcodeNumber>barcodeNumber){
            decrement(pointer.left, barcodeNumber, quantity);
        }
        else {
            decrement(pointer.right, barcodeNumber, quantity);
        }
    }
	public static void inorder(binarySearchTreeProductNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.println("**************************************");
        System.out.println("Barcodenumber: "+ root.barcodeNumber);
        System.out.println("Product : "+ root.productName);
        System.out.println("Quantity: "+ root.quantity);
        System.out.println("**************************************");
        inorder(root.right);
    }
	public static void preorder(binarySearchTreeProductNode root) {
        if (root == null) return;
        System.out.println("**************************************");
        System.out.println("Barcodenumber: "+ root.barcodeNumber);
        System.out.println("Product : "+ root.productName);
        System.out.println("Quantity: "+ root.quantity);
        System.out.println("**************************************");
        preorder(root.left);
        preorder(root.right);
    }
	public static void postorder(binarySearchTreeProductNode root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.println("**************************************");
        System.out.println("Barcodenumber: "+ root.barcodeNumber);
        System.out.println("Product : "+ root.productName);
        System.out.println("Quantity: "+ root.quantity);
        System.out.println("**************************************");
    }

}
