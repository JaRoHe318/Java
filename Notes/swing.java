
        JFrame frame = new JFrame();
        frame.setTitle("Toy");

        JPanel panel = new JPanel();

        JLabel first = new JLabel("First Name: ");
        panel.add(first);
        JTextField firstfield = new JTextField(10);
        panel.add(firstfield);

        JLabel last = new JLabel("Last Name: ");
        panel.add(last);
        JTextField lastfield = new JTextField(10);
        panel.add(lastfield);

//        JFrame frame = new JFrame();

        frame.add(panel);

        frame.setPreferredSize(new Dimension(400, 200));




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

