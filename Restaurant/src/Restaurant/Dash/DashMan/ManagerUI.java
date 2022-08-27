
package Restaurant.Dash.DashMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ManagerUI{

    static boolean maximized = true;
    int xMouse;
    int yMouse;
    private JButton btnExit;
    private JButton btnMaximize;
    private JButton btnMinimize;
    private JButton btnNews;
    private JButton btnQA;
    private JButton btnTimeline;
    private JButton btnTrending;

    private JFrame frame;

    private JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6,jLabel7,jLabel8,jLabel9,jLabel10,jLabel11,jLabel12,jLabel13,jLabel14,jLabel15,jLabel16,jLabel17,jLabel18,lblNews,lblQA,lblTimeline,lblTrending;

    private JPanel jPanel1,jPanel2,jPanel3,jPanel4,jPanel5,pnlBody,pnlHeader,pnlMenu,pnlNews,pnlTimeline;

    private JSeparator jSeparator1;
    private JScrollPane jspTimeline;


    public ManagerUI() {

        frame = new JFrame();

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel17 = new JLabel();
        jLabel18 = new JLabel();

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();
        jPanel5 = new JPanel();
        pnlMenu = new JPanel();
        pnlHeader = new JPanel();
        pnlBody = new JPanel();
        pnlNews = new JPanel();
        pnlTimeline = new JPanel();

        btnExit = new JButton();
        btnMaximize = new JButton();
        btnNews = new JButton();
        btnMinimize = new JButton();
        btnTimeline = new JButton();
        btnQA = new JButton();
        btnTrending = new JButton();

        lblTimeline = new JLabel();
        lblNews = new JLabel();
        lblTrending = new JLabel();
        lblQA = new JLabel();

        jspTimeline = new JScrollPane();
        jSeparator1 = new JSeparator();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Cube UI");
        frame.setUndecorated(true);
        frame.setSize(new Dimension(1000, 600));

        pnlHeader.setBackground(new Color(255, 255, 255));
        pnlHeader.setForeground(new Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new Color(255, 255, 255));
        btnExit.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/Exit.png")));
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.setRolloverIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/Exit (2).png")));
        btnExit.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMaximize.setBackground(new Color(255, 255, 255));
        btnMaximize.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/Maximize.png")));
        btnMaximize.setContentAreaFilled(false);
        btnMaximize.setFocusable(false);
        btnMaximize.setOpaque(true);
        btnMaximize.setRolloverIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/Maximize (2).png")));
        btnMaximize.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnMaximizeMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                btnMaximizeMouseExited(evt);
            }
        });
        btnMaximize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMaximizeActionPerformed(evt);
            }
        });

        btnMinimize.setBackground(new Color(255, 255, 255));
        btnMinimize.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/Minimize.png")));
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setFocusable(false);
        btnMinimize.setOpaque(true);
        btnMinimize.setRolloverIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/Minimize (2).png")));
        btnMinimize.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnMinimizeMouseEntered(evt);
            }
            public void mouseExited(MouseEvent evt) {
                btnMinimizeMouseExited(evt);
            }
        });
        btnMinimize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        GroupLayout pnlHeaderLayout = new GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
                pnlHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnMinimize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnMaximize, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnExit))
        );
        pnlHeaderLayout.setVerticalGroup(
                pnlHeaderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlHeaderLayout.createSequentialGroup()
                                .addGroup(pnlHeaderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnMaximize, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnExit, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnMinimize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );

        pnlMenu.setBackground(new Color(255, 255, 255));

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/User.png")));

        jLabel2.setFont(new Font("Berlin Sans FB Demi", 1, 20));
        jLabel2.setForeground(new Color(44, 62, 80));
        jLabel2.setText("CONAN DOYLE");

        jLabel3.setFont(new Font("Segoe UI", 0, 14));
        jLabel3.setForeground(new Color(127, 140, 141));
        jLabel3.setText("Manager");

        jLabel5.setFont(new Font("Segoe UI", 0, 13));
        jLabel5.setForeground(new Color(52, 152, 219));
        jLabel5.setText("Learn More");
        jLabel5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel4.setFont(new Font("Segoe UI", 0, 14));
        jLabel4.setForeground(new Color(127, 140, 141));
        jLabel4.setText("Working");

        btnTimeline.setFont(new Font("Berlin Sans FB Demi", 0, 16));
        btnTimeline.setForeground(new Color(44, 62, 80));
        btnTimeline.setText("DASHBOARD");
        btnTimeline.setContentAreaFilled(false);
        btnTimeline.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTimeline.setFocusable(false);
        btnTimeline.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTimelineActionPerformed(evt);
            }
        });

        lblTimeline.setBackground(new Color(0, 204, 106));
        lblTimeline.setOpaque(true);

        btnNews.setFont(new Font("Berlin Sans FB Demi", 0, 16));
        btnNews.setForeground(new Color(44, 62, 80));
        btnNews.setText("Need to add");
        btnNews.setContentAreaFilled(false);
        btnNews.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNews.setFocusable(false);
        btnNews.setPreferredSize(new Dimension(100, 27));
        btnNews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNewsActionPerformed(evt);
            }
        });

        lblNews.setBackground(new Color(255, 255, 255));
        lblNews.setOpaque(true);

        btnTrending.setFont(new Font("Berlin Sans FB Demi", 0, 16));
        btnTrending.setForeground(new Color(44, 62, 80));
        btnTrending.setText("Need to add");
        btnTrending.setContentAreaFilled(false);
        btnTrending.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTrending.setFocusable(false);
        btnTrending.setPreferredSize(new Dimension(100, 27));
        btnTrending.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTrendingActionPerformed(evt);
            }
        });

        lblTrending.setBackground(new Color(255, 255, 255));
        lblTrending.setOpaque(true);
        lblTrending.setPreferredSize(new Dimension(100, 0));

        btnQA.setFont(new Font("Berlin Sans FB Demi", 0, 16));
        btnQA.setForeground(new Color(44, 62, 80));
        btnQA.setText("Need To add");
        btnQA.setContentAreaFilled(false);
        btnQA.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnQA.setFocusable(false);
        btnQA.setPreferredSize(new Dimension(100, 27));
        btnQA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnQAActionPerformed(evt);
            }
        });

        lblQA.setBackground(new Color(255, 255, 255));
        lblQA.setOpaque(true);
        lblQA.setPreferredSize(new Dimension(100, 0));

        jLabel16.setFont(new Font("Segoe UI", 0, 14));
        jLabel16.setForeground(new Color(127, 140, 141));
        jLabel16.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel16.setText("You are login as Admin, ");

        jLabel17.setFont(new Font("Segoe UI", 0, 14));
        jLabel17.setForeground(new Color(52, 152, 219));
        jLabel17.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel17.setText("Logout ?");
        jLabel17.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GroupLayout pnlMenuLayout = new GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
                pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblTimeline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnTimeline, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(60, 60, 60)
                                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnNews, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                                .addGap(60, 60, 60)
                                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnTrending, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                        .addComponent(lblTrending, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(60, 60, 60)
                                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnQA, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lblQA, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15))
                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel16))
                                                        .addComponent(jLabel4)
                                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel5)))
                                                .addGap(0, 0, 0)
                                                .addComponent(jLabel17)
                                                .addGap(18, 18, 18))))
        );
        pnlMenuLayout.setVerticalGroup(
                pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pnlMenuLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel2)
                                                .addGap(5, 5, 5)
                                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel5))
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel4))
                                        .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel16)
                                                .addComponent(jLabel17)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnTimeline)
                                        .addComponent(btnNews, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblTimeline, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNews, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlMenuLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                                .addComponent(btnTrending, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lblTrending, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                                .addComponent(btnQA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lblQA, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE))))
        );

        pnlBody.setLayout(new CardLayout());

        jspTimeline.setBorder(null);
        jspTimeline.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlTimeline.setBackground(new Color(245, 245, 245));

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel6.setBackground(new Color(0, 204, 106));
        jLabel6.setFont(new Font("Segoe UI", 0, 14));
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Order");
        jLabel6.setOpaque(true);

        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/file-viewer.png")));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new Color(25, 255, 255));
        jPanel2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel7.setBackground(new Color(52, 152, 219));
        jLabel7.setFont(new Font("Segoe UI", 0, 14));
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel7.setText("Menu");
        jLabel7.setOpaque(true);

        jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel12.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/note.png")));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);

        jPanel2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {jPanel2MouseListener(e);}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e){}
        });


        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addContainerGap())
        );


        jPanel3.setBackground(new Color(255, 255, 255));
        jPanel3.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel8.setBackground(new Color(243, 156, 18));
        jLabel8.setFont(new Font("Segoe UI", 0, 14));
        jLabel8.setForeground(new Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel8.setText("Menu");
        jLabel8.setOpaque(true);

        jLabel13.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel13.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/settings.png")));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel4.setBackground(new Color(255, 255, 255));
        jPanel4.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel9.setBackground(new Color(149, 165, 166));
        jLabel9.setFont(new Font("Segoe UI", 0, 14));
        jLabel9.setForeground(new Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel9.setText("Register");
        jLabel9.setOpaque(true);

        jLabel14.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel14.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/browser.png")));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel5.setBackground(new Color(255, 255, 255));
        jPanel5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        jLabel10.setBackground(new Color(149, 165, 166));
        jLabel10.setFont(new Font("Segoe UI", 0, 14));
        jLabel10.setForeground(new Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel10.setText("Reports");
        jLabel10.setOpaque(true);

        jLabel15.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel15.setIcon(new ImageIcon(getClass().getResource("/Restaurant/Dash/img/bar-chart.png")));

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout pnlTimelineLayout = new GroupLayout(pnlTimeline);
        pnlTimeline.setLayout(pnlTimelineLayout);
        pnlTimelineLayout.setHorizontalGroup(
                pnlTimelineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlTimelineLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(pnlTimelineLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(pnlTimelineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlTimelineLayout.createSequentialGroup()
                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        pnlTimelineLayout.setVerticalGroup(
                pnlTimelineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlTimelineLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(pnlTimelineLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(pnlTimelineLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        jspTimeline.setViewportView(pnlTimeline);

        pnlBody.add(jspTimeline, "card2");

        pnlNews.setBackground(new Color(245, 245, 245));

        jLabel18.setFont(new Font("Berlin Sans FB Demi", 0, 16));
        jLabel18.setForeground(new Color(44, 62, 80));
        jLabel18.setText("NEWS");

        GroupLayout pnlNewsLayout = new GroupLayout(pnlNews);
        pnlNews.setLayout(pnlNewsLayout);
        pnlNewsLayout.setHorizontalGroup(
                pnlNewsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlNewsLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addGroup(pnlNewsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 870, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnlNewsLayout.setVerticalGroup(
                pnlNewsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnlNewsLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(298, Short.MAX_VALUE))
        );

        pnlBody.add(pnlNews, "card4");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(pnlHeader, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlMenu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlBody, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlHeader, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(pnlMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(pnlBody, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
        );

        frame.setSize(new Dimension(1000, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    private void btnExitMouseEntered(MouseEvent evt) {
        btnExit.setBackground(new Color(232,17,35));
    }

    private void btnExitMouseExited(MouseEvent evt) {
        btnExit.setBackground(new Color(255,255,255));
    }

    private void btnExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void btnMaximizeMouseEntered(MouseEvent evt) {
        btnMaximize.setBackground(new Color(229,229,229));
    }

    private void btnMaximizeMouseExited(MouseEvent evt) {
        btnMaximize.setBackground(new Color(255,255,255));
    }

    private void btnMaximizeActionPerformed(ActionEvent evt) {
        if(maximized){
            //handle fullscreen - taskbar
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
            frame.setMaximizedBounds(env.getMaximumWindowBounds());
            maximized = false;
        }else{
            frame.setExtendedState(JFrame.NORMAL);
            maximized = true;
        }
    }

    private void btnMinimizeMouseEntered(MouseEvent evt) {
        btnMinimize.setBackground(new Color(229,229,229));
    }

    private void btnMinimizeMouseExited(MouseEvent evt) {
        btnMinimize.setBackground(new Color(255,255,255));
    }

    private void btnMinimizeActionPerformed(ActionEvent evt) {
        frame.setState(Frame.ICONIFIED);
    }

    private void pnlHeaderMousePressed(MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }

    private void pnlHeaderMouseDragged(MouseEvent evt) {
        if(maximized){
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            frame.setLocation(x - xMouse, y - yMouse);
        }
    }

    private void btnNewsActionPerformed(ActionEvent evt) {
        lblNews.setBackground(new Color(0,204,106));

        lblTimeline.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
        lblQA.setBackground(new Color(255,255,255));

        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlNews);
        pnlBody.repaint();
        pnlBody.revalidate();
    }

    private void btnTrendingActionPerformed(ActionEvent evt) {
        lblTrending.setBackground(new Color(0,204,106));

        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblQA.setBackground(new Color(255,255,255));
    }

    private void btnQAActionPerformed(ActionEvent evt) {
        lblQA.setBackground(new Color(0,204,106));

        lblTimeline.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));
    }

    private void btnTimelineActionPerformed(ActionEvent evt) {
        lblTimeline.setBackground(new Color(0,204,106));

        lblQA.setBackground(new Color(255,255,255));
        lblNews.setBackground(new Color(255,255,255));
        lblTrending.setBackground(new Color(255,255,255));

        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(jspTimeline);
        pnlBody.repaint();
        pnlBody.revalidate();
    }


    private void jPanel2MouseListener(MouseEvent evt){
        addFoodDialog addFood = new addFoodDialog();
    }

    public JFrame getFrame() {return frame;}
}
