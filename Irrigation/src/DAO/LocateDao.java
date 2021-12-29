package DAO;

import model.AgriculturePlant;
import model.FarmType;
import model.Locate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocateDao implements Dao<Locate> {
    @Override
    public List<Locate> getAll() {
        Statement statement= null;
        List<Locate> locates = new ArrayList<Locate>();
        try {
            statement = dbConnector.getConnection().createStatement();
            String sql = "select * from Locates";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Locate locate = new Locate(resultSet.getString("LocateID"),
                        resultSet.getString("LocateName")
                );
                locates.add(locate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return locates;
    }

    public List<Locate> getAllLocateActivate()
    {
        List<Locate> locates = new ArrayList<Locate>();
        Connection connection = null;
        try {
            connection = dbConnector.getConnection();
            String query = "Select Locates.LocateID, Locates.LocateName from Locates " +
                    "inner join Farms on Farms.LocateID = Locates.LocateID " +
                    "inner join Plots on Farms.FarmID = Plots.FarmID " +
                    "where Farms.Status = 1 and Plots.status = 1" ;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.last();    // moves cursor to the last row
//            System.out.println("Result set size: " +  resultSet.getRow());
            while (resultSet.next()){

                Locate locate = new Locate(resultSet.getString("LocateID"),
                        resultSet.getString("LocateName")
                );
                locates.add(locate);
//                System.out.println(locate.toString());
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
        return locates;
    }

    @Override
    public Locate getById(int id) {
        Statement statement;
        Locate locate = null;
        try {
            statement = dbConnector.getConnection().createStatement();
            String sql = "select * from Locates where LocateID = "+id+";";
            ResultSet resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                locate = new Locate(resultSet.getString("LocateID"),
                        resultSet.getString("LocateName")
                );
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locate;
    }

    @Override
    public int save(Locate locate) {
        Statement statement;
        try {
            statement = dbConnector.getConnection().createStatement();
            String sql = "insert into Locates(LocateID, LocateName) values " +
                    "('"+locate.getLocateId()+"','"+locate.getLocate()+")";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(Locate t_old, Locate t_new) {

    }

    @Override
    public void delete(long id) {

    }
}
