package com.leartik.iberriozabal.erabiltzaile_kontuak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ErabiltzaileKontuaDB
{
	public static ArrayList<ErabiltzaileKontua> selectErabiltzaileKontuak()
	{
		Connection konexioa = null;
		Statement kontsulta = null;
		ResultSet erregistroak = null;
		ArrayList<ErabiltzaileKontua> erabiltzaileKontuak = new ArrayList<ErabiltzaileKontua>();

		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			konexioa = DriverManager.getConnection("jdbc:sqlite:c:\\xampp\\tomcat\\webapps\\Azterketa\\erabiltzaile-kontuak.db");
			kontsulta = konexioa.createStatement();
			erregistroak = kontsulta.executeQuery("select * from erabiltzaile_kontuak");

			while (erregistroak.next())
			{
				ErabiltzaileKontua erabiltzaileKontua = new ErabiltzaileKontua();
				erabiltzaileKontua.setId(erregistroak.getInt("id"));
				erabiltzaileKontua.setGunea(erregistroak.getString("webgunea"));
				erabiltzaileKontua.setErabiltzaileIzena(erregistroak.getString("erabiltzailea"));
				erabiltzaileKontua.setPasahitza(erregistroak.getString("pasahitza"));
				erabiltzaileKontuak.add(erabiltzaileKontua);
			}
		}
		catch (Exception e)
		{
			System.out.printf("Salbuespena: %s\n",e);
		}
		finally
		{
			if (erregistroak != null)
			{
				try
				{
					erregistroak.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (kontsulta != null)
			{
				try
				{
					kontsulta.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (konexioa != null)
			{
				try
				{
					konexioa.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}
		}

		return erabiltzaileKontuak;
	}

	public static ErabiltzaileKontua selectErabiltzaileKontua(int id)
	{
		Connection konexioa = null;
		Statement kontsulta = null;
		ResultSet erregistroa = null;
		ErabiltzaileKontua erabiltzaileKontua = null;

		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			konexioa = DriverManager.getConnection("jdbc:sqlite:c:\\xampp\\tomcat\\webapps\\Azterketa\\erabiltzaile-kontuak.db");
			kontsulta = konexioa.createStatement();
			erregistroa = kontsulta.executeQuery("select webgunea,erabiltzailea,pasahitza from erabiltzaile_kontuak where id=" + id );

			if (erregistroa.next())
			{
				erabiltzaileKontua = new ErabiltzaileKontua();
				erabiltzaileKontua.setId(id);
				erabiltzaileKontua.setGunea(erregistroa.getString("webgunea"));
				erabiltzaileKontua.setErabiltzaileIzena(erregistroa.getString("erabiltzailea"));
				erabiltzaileKontua.setPasahitza(erregistroa.getString("pasahitza"));
			}
		}
		catch (Exception e)
		{
			System.out.printf("Salbuespena: %s\n",e);
		}
		finally
		{
			if (erregistroa != null)
			{
				try
				{
					erregistroa.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (kontsulta != null)
			{
				try
				{
					kontsulta.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (konexioa != null)
			{
				try
				{
					konexioa.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}
		}

		return erabiltzaileKontua;
	}


	public static int insertErabiltzaileKontua(ErabiltzaileKontua erabiltzaileKontua)
	{
		Connection konexioa = null;
		Statement kontsulta = null;
		int emaitza;

		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			konexioa = DriverManager.getConnection("jdbc:sqlite:c:\\xampp\\tomcat\\webapps\\Azterketa\\erabiltzaile-kontuak.db");
			kontsulta = konexioa.createStatement();
			String sql = "insert into erabiltzaile_kontuak (webgunea,erabiltzailea,pasahitza) values (";
			sql = sql + " '" + erabiltzaileKontua.getGunea() + "'";
			sql = sql + ",'" + erabiltzaileKontua.getErabiltzaileIzena() + "'";
			sql = sql + ",'" + erabiltzaileKontua.getPasahitza() + "')";
			emaitza = kontsulta.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.printf("Salbuespena: %s\n",e);
			emaitza = 0;
		}
		finally
		{
			if (kontsulta != null)
			{
				try
				{
					kontsulta.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (konexioa != null)
			{
				try
				{
					konexioa.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}
		}

		return emaitza;
	}

	public static int updateErabiltzaileKontua(ErabiltzaileKontua erabiltzaileKontua)
	{
		Connection konexioa = null;
		Statement kontsulta = null;
		int emaitza;

		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			konexioa = DriverManager.getConnection("jdbc:sqlite:c:\\xampp\\tomcat\\webapps\\Azterketa\\erabiltzaile-kontuak.db");
			kontsulta = konexioa.createStatement();
			String sql = "update erabiltzaile_kontuak set";
			sql = sql + " webgunea='" + erabiltzaileKontua.getGunea() + "'";
			sql = sql + ",erabiltzailea='" + erabiltzaileKontua.getErabiltzaileIzena() + "'";
			sql = sql + ",pasahitza='" + erabiltzaileKontua.getPasahitza() + "'";
			sql = sql + " where id='" + erabiltzaileKontua.getId() + "'";
			emaitza = kontsulta.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.printf("Salbuespena: %s\n",e);
			emaitza = 0;
		}
		finally
		{
			if (kontsulta != null)
			{
				try
				{
					kontsulta.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (konexioa != null)
			{
				try
				{
					konexioa.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}
		}

		return emaitza;
	}

	public static int deleteErabiltzaileKontua(int id)
	{
		Connection konexioa = null;
		Statement kontsulta = null;
		int emaitza;

		try
		{
			Class.forName("org.sqlite.JDBC").newInstance();
			konexioa = DriverManager.getConnection("jdbc:sqlite:c:\\xampp\\tomcat\\webapps\\Azterketa\\erabiltzaile-kontuak.db");
			kontsulta = konexioa.createStatement();
			emaitza = kontsulta.executeUpdate("delete from erabiltzaile_kontuak where id=" + id);
		}
		catch (Exception e)
		{
			System.out.printf("Salbuespena: %s\n",e);
			emaitza = 0;
		}
		finally
		{
			if (kontsulta != null)
			{
				try
				{
					kontsulta.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}

			if (konexioa != null)
			{
				try
				{
					konexioa.close();
				}
				catch (Exception e)
				{
					System.out.printf("Salbuespena: %s\n",e);
				}
			}
		}

		return emaitza;
	}
}
