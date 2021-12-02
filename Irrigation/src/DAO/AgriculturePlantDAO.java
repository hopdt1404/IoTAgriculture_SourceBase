package DAO;

import model.AgriculturePlant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class AgriculturePlantDAO implements Dao<AgriculturePlant> {
    public List<AgriculturePlant> getAll() {
        List<AgriculturePlant> agriculturePlants = new ArrayList<AgriculturePlant>();
        return agriculturePlants;
    }
    @Override
    public AgriculturePlant getById(int id) {
        return null;
    }
    public AgriculturePlant getById(Long id) {
        return null;
    }

    public List<AgriculturePlant> getAgriculturePlantValid() {
        List<AgriculturePlant> agriculturePlants = new ArrayList<AgriculturePlant>();
        Connection connection = null;
        try {
            connection = dbConnector.getConnection();
            String query = "select agriculture_plants.id, agriculture_plants.plant_id, agriculture_plants.plant_state_id, agriculture_plants.PlotID, agriculture_plants.growth_period, agriculture_plants.temperature, agriculture_plants.moisture " +
                    "from Farms inner join Plots on Plots.FarmID = Farms.FarmID " +
                    "inner join farm_plants on (Plots.PlotID = farm_plants.PlotID and Plots.plant_id = farm_plants.plant_id)" +
                    "inner join agriculture_plants on (agriculture_plants.PlotID = farm_plants.PlotID and agriculture_plants.plant_id = farm_plants.plant_id and agriculture_plants.plant_state_id = farm_plants.current_plant_state)" +
                    "where Farms.Status = 1 and Plots.status = 1 and farm_plants.status = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.last();    // moves cursor to the last row
//            System.out.println("Result set size: " +  resultSet.getRow());
            while (resultSet.next()){

                System.out.println("PlotID: " + resultSet.getLong("PlotID"));
                AgriculturePlant agriculturePlant = new AgriculturePlant(
                        resultSet.getLong("id"),
                        resultSet.getLong("plant_id"),
                        resultSet.getInt("plant_state_id"),
                        resultSet.getLong("PlotID"),
                        resultSet.getInt("growth_period"),
                        resultSet.getFloat("temperature"),
                        resultSet.getFloat("moisture")
                );
                agriculturePlants.add(agriculturePlant);
                System.out.println(agriculturePlant.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return agriculturePlants;
    }

    public int save (AgriculturePlant agriculturePlant) {
        return  0;
    }

    @Override
    public void update(AgriculturePlant t_old, AgriculturePlant t_new) {

    }

    @Override
    public void delete(long id) {

    }
}
