import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class Mgrid{
   
    public static void main(String[] args) throws Exception{
        //General initialisation and declaration
        int pxCount = 0; //Used for giving each pixel and ID
        //Color inFocus = new Color(52, 53, 54); //Colours for when the panel is in/out of focus
        Color noFocus = new Color(47, 48, 49);
        
        GridBagConstraints justifyPanels = new GridBagConstraints(); //Used for justifying the layout of the master panels
        pixel[][] grid = new pixel[20][20]; //Create a 20x20 array of pixel objects (setup happens later)
        int length = grid.length; //Used for loops during setup of the canvas

        //The master frame
        JFrame win = new JFrame("MGrid");

        //Creating instances for the different panels
        JPanel global = new JPanel(new GridBagLayout()); //Master panel which everything is in
        
        JPanel sideBar = new JPanel(); //Contains side bar elements
        JPanel canvas = new JPanel(new GridLayout(20,20)); //Contains the pixels

        //Setup for the master frame
        win.setBounds(200, 200, 900, 900); //Place a 900x900 window at 200,200 (200 px down and right from top left)
        win.setContentPane(global); //global is the main parent pannel
        //Setup for the panels
        sideBar.setPreferredSize(new Dimension(100,500));
        sideBar.setBackground(noFocus); //Same colour as the background, I just want the sidebar to act as a formatting div

        canvas.setPreferredSize(new Dimension(500, 500));

        global.setSize(900, 900);
        global.setOpaque(true);
        global.setFocusable(true);
        global.setBackground(noFocus);
  

        justifyPanels.gridx = 0;
        justifyPanels.weightx = 1.0; //This line is essential!! It makes the canvas margin fill all, pushing the sideBar far right as long as it's got a weight of 0
        justifyPanels.anchor = GridBagConstraints.CENTER; //Center justification
        global.add(canvas, justifyPanels); //Global is the parent of canvas
        
        justifyPanels.gridx = 1;
        justifyPanels.weightx = 0;
        justifyPanels.anchor = GridBagConstraints.EAST;
        global.add(sideBar, justifyPanels); //Global is the parent of sideBar

        btn picker = new btn(true, "COL", 0); //Thie will eventually be a colour picker, likely won't be a btn class at all
        btn rainbow = new btn(true, "RBW", 1); //Rainbow mode
        btn eraser = new btn(true, "ERS", 2); //Eraser
        Clear clear = new Clear(true, "CLR", 3); //Clear

        sideBar.add(picker); //Colour Picker
        sideBar.add(rainbow); //Rainbow mode
        sideBar.add(eraser); //Eraser
        sideBar.add(clear); //Clear

        //Create the grid of pixels
        for(int x = 0; x < length; x++){
            for(int y = 0; y < length; y++){
                //Actually create the new pixel and add it
                grid[x][y] = new pixel(25, 25, pxCount);
                canvas.add(grid[x][y]); //Note, you HAVE to use the GridBagConstraints type here otherwise it overloads to something else >:()
                pxCount++; //Used for the IDs, increment with every loop
            }
        }

        System.out.println(pxCount); //Prints the number of pixels
        System.out.println(length); //Prints the width/length of the grid
        win.setVisible(true); //This little piece of shit MUST be called after everything is added, I can't believe I just wasted 2 hours bug fixing THIS.
        
        /*Uncomment this if you want to print all of the avaliable fonts- I was just using this to work out which fonts I could use for the buttons
        GraphicsEnvironment ff = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String fonts[] = ff.getAvailableFontFamilyNames();
        for (String i : fonts) {
            System.out.println(i + " ");
        }
        */

        
        //Event listeners
        //Logic for the colour picker
        picker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JColorChooser cp = new JColorChooser(noFocus);
                cp.getSelectionModel().addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e){
                        Color temp = cp.getColor();

                        for(int x = 0; x < grid.length; x++){
                            for(int y = 0; y < grid.length; y++){
                                grid[x][y].activeColor = temp;
                            }
                        }

                    }
                });



                JFrame cpWindow = new JFrame("Colour Picker");
                cpWindow.setBounds(10100, 200, 800, 500);
                cpWindow.setBackground(noFocus);
                cpWindow.add(cp);
                cpWindow.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosing(WindowEvent e){
                        picker.selected = false;
                        picker.changeSelectColour(picker.selected);
                        cpWindow.setVisible(false);
                    }
                });
                cpWindow.setVisible(true);
            }

        });

        //Logic for the clear button
        clear.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            for(int x = 0; x < grid.length; x++){
                for(int y = 0; y < grid.length; y++){
                    grid[x][y].setBackground(new Color(255,255,255)); //Set everything to white
                }
            }

         }
        });

        eraser.addActionListener( new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            
            for(int x = 0; x < grid.length; x++){
                for(int y = 0; y < grid.length; y++){
                    grid[x][y].erasing = !grid[x][y].erasing;
                }
            }

         }
        });

        //Close the window when user closes the window :fire:
        //frame.addWindowListener is very similar to add event listener in js
        win.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        global.addFocusListener(new FocusAdapter(){
            @Override
            public void focusLost(FocusEvent e){
                System.out.println("Lost focus... :(");
                //global.setBackground(noFocus);
                //sideBar.setBackground(noFocus);
            }
        });

        global.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                System.out.println("Welcome back!! :)");
                //global.setBackground(inFocus);
                //sideBar.setBackground(inFocus);
            }
        });
        
    }
}
    
    
    