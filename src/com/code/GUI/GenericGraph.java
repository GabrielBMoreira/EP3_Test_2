package com.code.GUI;

import java.sql.ResultSet;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

public class GenericGraph extends ApplicationFrame {

    public GenericGraph(String applicationTitle , String chartTitle, List<String[]> data, String chartType ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Data", chartType.equals("comprados") ? "Custo" : "Quantidade",
                createDataset(data, chartType),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    public GenericGraph(String title) {
        super(title);
    }

    private DefaultCategoryDataset createDataset( List<String[]> data, String chartType) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

        data.forEach(dataPoint -> dataset.addValue(Double.parseDouble(dataPoint[2]), chartType.equals("comprados") ? "Objetos comprados" : "Objetos emprestados", dataPoint[1]));

        return dataset;
    }

    public static void main( String[ ] args ) {

    }
}