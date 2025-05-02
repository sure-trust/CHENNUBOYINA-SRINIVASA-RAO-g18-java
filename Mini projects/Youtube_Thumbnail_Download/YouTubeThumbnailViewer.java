import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class YouTubeThumbnailViewer extends JFrame {

    private JTextField urlField;
    private JButton fetchButton;
    private JButton downloadButton;
    private JLabel imageLabel;

    private JComboBox<String> qualityCombo;
    private JComboBox<String> formatCombo;

    private BufferedImage currentThumbnail = null;
    private String currentVideoId = null;

    // Mapping of resolution to thumbnail quality names
    private final String[][] qualityMap = {
            {"1080p", "maxresdefault"},
            {"720p", "maxresdefault"},
            {"480p", "sddefault"},
            {"360p", "hqdefault"},
            {"240p", "mqdefault"},
            {"144p", "default"}
    };

    private final String[] formats = {"jpg", "png"};

    public YouTubeThumbnailViewer() {
        setTitle("YouTube Thumbnail Viewer");
        setSize(650, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());

        urlField = new JTextField(30);
        fetchButton = new JButton("Fetch Thumbnail");
        downloadButton = new JButton("Download");
        downloadButton.setEnabled(false);

        qualityCombo = new JComboBox<>();
        for (String[] entry : qualityMap) {
            qualityCombo.addItem(entry[0]); // Show resolutions like "720p"
        }

        formatCombo = new JComboBox<>(formats);

        topPanel.add(new JLabel("YouTube URL:"));
        topPanel.add(urlField);
        topPanel.add(fetchButton);
        topPanel.add(new JLabel("Quality:"));
        topPanel.add(qualityCombo);
        topPanel.add(new JLabel("Format:"));
        topPanel.add(formatCombo);
        topPanel.add(downloadButton);

        imageLabel = new JLabel("Thumbnail will appear here", SwingConstants.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);

        // Fetch Button Action
        fetchButton.addActionListener(e -> {
            String videoUrl = urlField.getText().trim();
            try {
                String videoId = extractVideoId(videoUrl);
                if (videoId == null) {
                    JOptionPane.showMessageDialog(null, "Invalid YouTube URL!");
                    return;
                }

                currentVideoId = videoId;
                String selectedLabel = (String) qualityCombo.getSelectedItem();
                String selectedQuality = null;
                for (String[] entry : qualityMap) {
                    if (entry[0].equals(selectedLabel)) {
                        selectedQuality = entry[1];
                        break;
                    }
                }

                String thumbnailUrl = "https://img.youtube.com/vi/" + videoId + "/" + selectedQuality + ".jpg";

                try {
                    BufferedImage thumbnail = ImageIO.read(new URL(thumbnailUrl));
                    if (thumbnail != null) {
                        currentThumbnail = thumbnail;
                        downloadButton.setEnabled(true);
                        imageLabel.setIcon(new ImageIcon(thumbnail));
                        imageLabel.setText("");
                    } else {
                        throw new IOException("Thumbnail not found.");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Could not load thumbnail: " + ex.getMessage());
                    currentThumbnail = null;
                    imageLabel.setIcon(null);
                    imageLabel.setText("Thumbnail not found.");
                    downloadButton.setEnabled(false);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Download Button Action
        downloadButton.addActionListener(e -> {
            if (currentVideoId != null) {
                String selectedFormat = (String) formatCombo.getSelectedItem();
                String selectedRes = (String) qualityCombo.getSelectedItem();

                String selectedQuality = null;
                for (String[] entry : qualityMap) {
                    if (entry[0].equals(selectedRes)) {
                        selectedQuality = entry[1];
                        break;
                    }
                }

                try {
                    String thumbnailUrl = "https://img.youtube.com/vi/" + currentVideoId + "/" + selectedQuality + ".jpg";
                    BufferedImage thumbnail = ImageIO.read(new URL(thumbnailUrl));
                    if (thumbnail == null) {
                        JOptionPane.showMessageDialog(null, "Thumbnail not found for selected quality.");
                        return;
                    }

                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setSelectedFile(new File("thumbnail_" + currentVideoId + "_" + selectedRes + "." + selectedFormat));
                    int result = fileChooser.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        ImageIO.write(thumbnail, selectedFormat, file);
                        JOptionPane.showMessageDialog(null, "Saved to: " + file.getAbsolutePath());
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Failed to download: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
    }

    private String extractVideoId(String url) {
        try {
            if (url.contains("youtu.be/")) {
                return url.substring(url.lastIndexOf("/") + 1).split("\\?")[0];
            } else if (url.contains("youtube.com/watch?v=")) {
                String[] parts = url.split("v=");
                String id = parts[1];
                int ampIndex = id.indexOf('&');
                if (ampIndex != -1) {
                    id = id.substring(0, ampIndex);
                }
                return id;
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new YouTubeThumbnailViewer().setVisible(true));
    }
}
