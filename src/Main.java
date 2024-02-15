import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel rootPanel;
    private JPanel headPanel;
    private JLabel heading;
    private JPanel bodyPanel;
    private JButton button;
    private JLabel locationLabel;
    private JLabel destinationLabel;
    private JLabel outputBox1;
    private JComboBox LocationSelector;
    private JComboBox DestinationSelector;
    private JLabel outputBox2;


    private static JFrame frame = new JFrame("SHORTEST PATH FINDER");
    public static JFrame getFrame() {
        return frame;
    }
    public Main() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = LocationSelector.getSelectedItem().toString();
                String destination = DestinationSelector.getSelectedItem().toString();



                Node loc1;
                Node loc2;
                // Destinations
                Graph graph = new Graph(true);
                Node SamJonah = new Node(0, "Sam Jonah Library");
                

                loc1 = SamJonah;
                loc2 = RoundAbout;
                // Our addEdge method automatically adds Nodes as well.
                // The addNode method is only there for unconnected Nodes,
                // if we wish to add any
                graph.addEdge(ScienceGate, WestGate, 1.6);

                //System.out.println("Input current location");

                String currentLocation = location;
                switch (currentLocation) {
                    case "Sam Jonah Library":
                        loc1 = SamJonah;
                        break;
                    case "West Gate":
                        loc1 = WestGate;
                        break;
                    case "Amissah Arthur Language Centre":
                        loc1 = AmissahArthur;
                        break;
                    case "Congregational Grounds":
                        loc1 = CongregationalGrounds;
                        break;
                    case "Calc":
                        loc1 = Calc;
                        break;
                    case "Old site":
                        loc1 = OldSite;
                        break;
                    case "NLT Building":
                        loc1 = NLT;
                        break;
                    case "Science Gate":
                        loc1 = ScienceGate;
                        break;
                    case "Valco Hall":
                        loc1 = ValcoHall;
                        break;
                    case "Science Market":
                        loc1 = ScienceMarket;
                        break;
                    case "College of Distance Education":
                        loc1 = Code;
                        break;
                    case "New Examination Center (NEC)":
                        loc1 = NEC;
                        break;
                    case "Round About":
                        loc1 = RoundAbout;
                        break;
                    case "Shuttle Terminal":
                        loc1 = ShuttleTerminal;
                        break;

                }


                String whereTo = destination;

                switch (whereTo) {
                    case "Sam Jonah Library":
                        loc2 = SamJonah;
                        break;
                    case "West Gate":
                        loc2 = WestGate;
                        break;
                    case "Amissah Arthur Language Centre":
                        loc2 = AmissahArthur;
                        break;
                    case "Congregational Grounds":
                        loc2 = CongregationalGrounds;
                        break;
                    case "Calc":
                        loc2 = Calc;
                        break;
                    case "Old site":
                        loc2 = OldSite;
                        break;
                    case "NLT Building":
                        loc2 = NLT;
                        break;
                    case "Science Gate":
                        loc2 = ScienceGate;
                        break;
                    case "Valco Hall":
                        loc2 = ValcoHall;
                        break;
                    case "Science Market":
                        loc2 = ScienceMarket;
                        break;
                    case "College of Distance Education":
                        loc2 = Code;
                        break;
                    case "New Examination Center (NEC)":
                        loc2 = NEC;
                        break;
                    case "Round About":
                        loc2 = RoundAbout;
                        break;
                    case "Shuttle Terminal":
                        loc2 = ShuttleTerminal;
                        break;
                }

                String path = graph.shortestPath(loc1, loc2);
                outputBox1.setText("From: "+ loc1.name);
                outputBox2.setText("To: "+ loc2.name);

                JOptionPane optionPane = new JOptionPane(path, JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("The Shortest Path");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        showMain();
    }

    public  static  void showMain()
    {
        getFrame().setContentPane(new Main().rootPanel);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().pack();
        getFrame().setLocationRelativeTo(null);
        getFrame().setResizable(true);
        getFrame().setVisible(true);
        frame.setSize(900, 600);
    }
}
