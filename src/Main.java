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
                Node Potosi = new Node(0, "Potosi");
                Node Challapata = new Node(1, "Challapata");
                Node Machacamarca = new Node(2, "Machacamarca");
                Node Sultaca = new Node(3, "Sultaca");
                Node ElPuente = new Node(4, "El Puente");
                Node Betanzos = new Node(5, "Betanzos");
                Node Millares = new Node(6, "Millares");
                Node Oruro = new Node(7, "Oruro");
                Node Patacamaya = new Node(8, "Patacamaya");
                Node Calamarca = new Node(9, "Calamarca");
                Node CalaCala = new Node(10, "Cala Cala");
                Node Ocuri = new Node(11, "Ocuri");
                Node Confital = new Node(12, "Confital");
                Node Parotani = new Node(13, "Parotani");
                Node LaPaz = new Node(14, "La Paz");
                Node SanMiguelDelBala = new Node(15, "San Miguel Del Bala");
                Node BuenaHora = new Node(16, "Buena Hora");
                Node SicaSica = new Node(17, "Sica Sica");
                Node Pongo = new Node(18, "Pongo");
                Node Yucumo = new Node(19, "Yucumo");
                Node SanIgnacioDeMoxos = new Node(20, "San Ignacio De Moxos");
                Node Pando = new Node(21, "Pando");
                Node Naranjal = new Node(22, "Naranjal");
                Node ElCerrito = new Node(23, "El Cerrito");
                Node Tarija = new Node(24, "Tarija");
                Node Camargo = new Node(25, "Camargo");
                Node Camiri = new Node(26, "Camiri");
                Node Cabezas = new Node(27, "Cabezas");
                Node Chuquisaca = new Node(28, "Chuquisaca");
                Node Aiquile = new Node(29, "Aiquile");
                Node Punata = new Node(30, "Punata");
                Node Pampagrande = new Node(31, "Pampagrande");
                Node Jorochito = new Node(32, "Jorochito");
                Node Cochabamba = new Node(33, "Cochabamba");
                Node BuloBulo = new Node(34, "Bulo Bulo");
                Node LaArboleda = new Node(35, "La Arboleda");
                Node Beni = new Node(36, "Beni");
                Node Embocada = new Node(37, "Embocada");
                Node Yotau = new Node(38, "Yotau");
                Node SantaCruz = new Node(39, "Santa Cruz");

                loc1 = Potosi;
                loc2 = SantaCruz;

                // Our addEdge method automatically adds Nodes as well.
                // The addNode method is only there for unconnected Nodes,
                // if we wish to add any
                graph.addEdge(Potosi,Challapata,7.3);
                graph.addEdge(Challapata,Machacamarca,4.3);
                graph.addEdge(Machacamarca,Oruro,2.9);

                graph.addEdge(Potosi,Sultaca,9.2);
                graph.addEdge(Sultaca,ElPuente,6.3);
                graph.addEdge(ElPuente,Tarija,4.5);

                graph.addEdge(Potosi,Betanzos,4.5);
                graph.addEdge(Betanzos,Millares,5.8);
                graph.addEdge(Millares,Chuquisaca,4.6);

                graph.addEdge(Oruro,Machacamarca ,2.9);
                graph.addEdge(Machacamarca,Challapata ,4.3);
                graph.addEdge(Challapata,Potosi ,7.3);

                graph.addEdge(Oruro,Patacamaya,7.4);
                graph.addEdge(Patacamaya,Calamarca,4.2);
                graph.addEdge(Calamarca,LaPaz,3.4);

                graph.addEdge(Oruro,CalaCala,6.4);
                graph.addEdge(CalaCala,Ocuri,7.2);
                graph.addEdge(Ocuri,Chuquisaca,5.4);

                graph.addEdge(Oruro,Confital,8.3);
                graph.addEdge(Confital,Parotani,6.7);
                graph.addEdge(Parotani,Cochabamba,4.2);

                graph.addEdge(LaPaz,Calamarca,3.4);
                graph.addEdge(Calamarca,Patacamaya,4.2);
                graph.addEdge(Patacamaya,Oruro,7.4);

                graph.addEdge(LaPaz,SanMiguelDelBala,9.7);
                graph.addEdge(SanMiguelDelBala,BuenaHora,9.4);
                graph.addEdge(BuenaHora,Pando,10.3);

                graph.addEdge(LaPaz,SicaSica,7.3);
                graph.addEdge(SicaSica,Pongo,8.3);
                graph.addEdge(Pongo,Cochabamba,5.4);

                graph.addEdge(LaPaz,Yucumo,12.1);
                graph.addEdge(Yucumo,SanIgnacioDeMoxos,5.6);
                graph.addEdge(SanIgnacioDeMoxos,Beni,3.6);

                graph.addEdge(Pando,BuenaHora,10.3);
                graph.addEdge(BuenaHora,SanMiguelDelBala,9.4);
                graph.addEdge(SanMiguelDelBala,LaPaz,9.7);

                graph.addEdge(Pando,Naranjal,9.2);
                graph.addEdge(Naranjal,ElCerrito,9.2);
                graph.addEdge(ElCerrito,Beni,12.10);

                graph.addEdge(Tarija,ElPuente,4.5);
                graph.addEdge(ElPuente,Sultaca,6.3);
                graph.addEdge(Sultaca,Potosi,9.2);

                graph.addEdge(Tarija,Camargo,7.1);
                graph.addEdge(Camargo,Betanzos,8.1);
                graph.addEdge(Betanzos,Chuquisaca,6.2);

                graph.addEdge(Tarija,Camiri,10.2);
                graph.addEdge(Camiri,Cabezas,9.2);
                graph.addEdge(Cabezas,SantaCruz,6.1);

                graph.addEdge(Chuquisaca,Millares,4.7);
                graph.addEdge(Millares,Betanzos,5.8);
                graph.addEdge(Betanzos,Potosi,4.5);

                graph.addEdge(Chuquisaca,Ocuri,5.4);
                graph.addEdge(Ocuri,CalaCala,7.2);
                graph.addEdge(CalaCala,Oruro,6.4);

                graph.addEdge(Chuquisaca,Betanzos,6.2);
                graph.addEdge(Betanzos,Camargo,8.1);
                graph.addEdge(Camargo,Tarija,7.1);

                graph.addEdge(Chuquisaca,Aiquile,7.4);
                graph.addEdge(Aiquile,Punata,6.3);
                graph.addEdge(Punata,Cochabamba,3.3);

                graph.addEdge(Chuquisaca,Pampagrande,9.8);
                graph.addEdge(Pampagrande,Jorochito,7.4);
                graph.addEdge(Jorochito,SantaCruz,4.2);

                graph.addEdge(Cochabamba,Pongo,5.4);
                graph.addEdge(Pongo,SicaSica,8.3);
                graph.addEdge(SicaSica,LaPaz,7.3);

                graph.addEdge(Cochabamba,Parotani,4.2);
                graph.addEdge(Parotani,Confital,6.7);
                graph.addEdge(Confital,Oruro,8.3);

                graph.addEdge(Cochabamba,Punata,3.2);
                graph.addEdge(Punata,Aiquile,6.3);
                graph.addEdge(Aiquile,Chuquisaca,7.4);

                graph.addEdge(Cochabamba,BuloBulo,8.1);
                graph.addEdge(BuloBulo,LaArboleda,7.1);
                graph.addEdge(LaArboleda,SantaCruz,6.1);

                graph.addEdge(Beni,SanIgnacioDeMoxos,3.6);
                graph.addEdge(SanIgnacioDeMoxos,Yucumo,5.6);
                graph.addEdge(Yucumo,LaPaz,12.1);

                graph.addEdge(Beni,ElCerrito,12.1);
                graph.addEdge(ElCerrito,Naranjal,9.2);
                graph.addEdge(Naranjal,Pando,9.2);

                graph.addEdge(Beni,Embocada,8.4);
                graph.addEdge(Embocada,Yotau,7.4);
                graph.addEdge(Yotau,SantaCruz,8.1);

                graph.addEdge(SantaCruz,Jorochito,4.2);
                graph.addEdge(Jorochito,Pampagrande,7.4);
                graph.addEdge(Pampagrande,Chuquisaca,9.8);

                graph.addEdge(SantaCruz,LaArboleda,6.1);
                graph.addEdge(LaArboleda,BuloBulo,7.1);
                graph.addEdge(BuloBulo,Cochabamba,8.1);

                graph.addEdge(SantaCruz,Cabezas,6.1);
                graph.addEdge(Cabezas,Camiri,9.2);
                graph.addEdge(Camiri,Tarija,10.2);

                graph.addEdge(SantaCruz,Yotau,8.1);
                graph.addEdge(Yotau,Embocada,7.4);
                graph.addEdge(Embocada,Beni,8.4);

                String currentLocation = location;
                switch (currentLocation) {
                    case "Potosi":
                        loc1 = Potosi;
                        break;
                    case "Challapata":
                        loc1 = Challapata;
                        break;
                    case "Machacamarca":
                        loc1 = Machacamarca;
                        break;
                    case "Sultaca":
                        loc1 = Sultaca;
                        break;
                    case "El Puente":
                        loc1 = ElPuente;
                        break;
                    case "Betanzos":
                        loc1 = Betanzos;
                        break;
                    case "Millares":
                        loc1 = Millares;
                        break;
                    case "Oruro":
                        loc1 = Oruro;
                        break;
                    case "Patacamaya":
                        loc1 = Patacamaya;
                        break;
                    case "Calamarca":
                        loc1 = Calamarca;
                        break;
                    case "Cala Cala":
                        loc1 = CalaCala;
                        break;
                    case "Ocuri":
                        loc1 = Ocuri;
                        break;
                    case "Confital":
                        loc1 = Confital;
                        break;
                    case "Parotani":
                        loc1 = Parotani;
                        break;
                    case "La Paz":
                        loc1 = LaPaz;
                        break;
                    case "San Miguel Del Bala":
                        loc1 = SanMiguelDelBala;
                        break;
                    case "Buena Hora":
                        loc1 = BuenaHora;
                        break;
                    case "Sica Sica":
                        loc1 = SicaSica;
                        break;
                    case "Pongo":
                        loc1 = Pongo;
                        break;
                    case "Yucumo":
                        loc1 = Yucumo;
                        break;
                    case "San Ignacio De Moxos":
                        loc1 = SanIgnacioDeMoxos;
                        break;
                    case "Pando":
                        loc1 = Pando;
                        break;
                    case "Naranjal":
                        loc1 = Naranjal;
                        break;
                    case "El Cerrito":
                        loc1 = ElCerrito;
                        break;
                    case "Tarija":
                        loc1 = Tarija;
                        break;
                    case "Camargo":
                        loc1 = Camargo;
                        break;
                    case "Camiri":
                        loc1 = Camiri;
                        break;
                    case "Cabezas":
                        loc1 = Cabezas;
                        break;
                    case "Chuquisaca":
                        loc1 = Chuquisaca;
                        break;
                    case "Aiquile":
                        loc1 = Aiquile;
                        break;
                    case "Punata":
                        loc1 = Punata;
                        break;
                    case "Pampagrande":
                        loc1 = Pampagrande;
                        break;
                    case "Jorochito":
                        loc1 = Jorochito;
                        break;
                    case "Cochabamba":
                        loc1 = Cochabamba;
                        break;
                    case "Bulo Bulo":
                        loc1 = BuloBulo;
                        break;
                    case "La Arboleda":
                        loc1 = LaArboleda;
                        break;
                    case "Beni":
                        loc1 = Beni;
                        break;
                    case "Embocada":
                        loc1 = Embocada;
                        break;
                    case "Yotau":
                        loc1 = Yotau;
                        break;
                    case "Santa Cruz":
                        loc1 = SantaCruz;
                        break;

                }


                String whereTo = destination;

                switch (whereTo) {
                    case "Potosi":
                        loc2 = Potosi;
                        break;
                    case "Challapata":
                        loc2 = Challapata;
                        break;
                    case "Machacamarca":
                        loc2 = Machacamarca;
                        break;
                    case "Sultaca":
                        loc2 = Sultaca;
                        break;
                    case "El Puente":
                        loc2 = ElPuente;
                        break;
                    case "Betanzos":
                        loc2 = Betanzos;
                        break;
                    case "Millares":
                        loc2 = Millares;
                        break;
                    case "Oruro":
                        loc2 = Oruro;
                        break;
                    case "Patacamaya":
                        loc2 = Patacamaya;
                        break;
                    case "Calamarca":
                        loc2 = Calamarca;
                        break;
                    case "Cala Cala":
                        loc2 = CalaCala;
                        break;
                    case "Ocuri":
                        loc2 = Ocuri;
                        break;
                    case "Confital":
                        loc2 = Confital;
                        break;
                    case "Parotani":
                        loc2 = Parotani;
                        break;
                    case "La Paz":
                        loc2 = LaPaz;
                        break;
                    case "San Miguel Del Bala":
                        loc2 = SanMiguelDelBala;
                        break;
                    case "Buena Hora":
                        loc2 = BuenaHora;
                        break;
                    case "Sica Sica":
                        loc2 = SicaSica;
                        break;
                    case "Pongo":
                        loc2 = Pongo;
                        break;
                    case "Yucumo":
                        loc2 = Yucumo;
                        break;
                    case "San Ignacio De Moxos":
                        loc2 = SanIgnacioDeMoxos;
                        break;
                    case "Pando":
                        loc2 = Pando;
                        break;
                    case "Naranjal":
                        loc2 = Naranjal;
                        break;
                    case "El Cerrito":
                        loc2 = ElCerrito;
                        break;
                    case "Tarija":
                        loc2 = Tarija;
                        break;
                    case "Camargo":
                        loc2 = Camargo;
                        break;
                    case "Camiri":
                        loc2 = Camiri;
                        break;
                    case "Cabezas":
                        loc2 = Cabezas;
                        break;
                    case "Chuquisaca":
                        loc2 = Chuquisaca;
                        break;
                    case "Aiquile":
                        loc2 = Aiquile;
                        break;
                    case "Punata":
                        loc2 = Punata;
                        break;
                    case "Pampagrande":
                        loc2 = Pampagrande;
                        break;
                    case "Jorochito":
                        loc2 = Jorochito;
                        break;
                    case "Cochabamba":
                        loc2 = Cochabamba;
                        break;
                    case "Bulo Bulo":
                        loc2 = BuloBulo;
                        break;
                    case "La Arboleda":
                        loc2 = LaArboleda;
                        break;
                    case "Beni":
                        loc2 = Beni;
                        break;
                    case "Embocada":
                        loc2 = Embocada;
                        break;
                    case "Yotau":
                        loc2 = Yotau;
                        break;
                    case "Santa Cruz":
                        loc2 = SantaCruz;
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
