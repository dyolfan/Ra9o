/*     */ package jtm.activity14;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import jtm.TestUtils;
/*     */ import org.apache.log4j.Logger;
import org.junit.After;
/*     */ import org.junit.Assert;
import org.junit.Before;
/*     */ import org.junit.BeforeClass;
/*     */ import org.junit.FixMethodOrder;
/*     */ import org.junit.Test;
/*     */ import org.junit.runners.MethodSorters;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @FixMethodOrder(MethodSorters.NAME_ASCENDING)
/*     */ public class DatabaseUnitTest1
/*     */ {
/*  26 */   private static boolean dirtyDatabase = true;
/*  27 */   private static Logger logger = Logger.getLogger(DatabaseUnitTest1.class);
/*     */   
/*     */   private static Connection conn;
/*     */   
/*     */   private static StudentManager manager;
/*  32 */   private static String fnameToDelete = "To be";
/*  33 */   private static String lnameToDelete = "Deleted";
/*  34 */   private static int idToDelete = 5;
/*     */   
/*     */   @BeforeClass
/*     */   public static void setUpBeforeClass() {
/*  38 */     String password = "abcd1234";
/*     */     try {
/*  40 */       TestUtils.checkMySQL();
/*     */       
/*  42 */       Assert.assertTrue("Password '" + password + "' for root user of MySQL doesn't work.", "0\n".equals(
/*  43 */         TestUtils.executeCmd("mysql -uroot -p" + password + " --execute=quit 2>/dev/null; echo $?")));
/*     */       
/*  45 */       if ("".equals(TestUtils.executeCmd("mysql -s -uroot -p" + password + " -e \"show databases;\" 2>/dev/null|grep database_activity")))
/*     */       {
/*  47 */         logger.warn("There was no database 'database_activity' when test was started;");
/*     */       }
/*  49 */       resetDatabase();
/*  50 */       logger.info("Database was dropped and recreated");
/*     */       
/*  52 */       Assert.assertTrue("Database 'database_activity' is not created.", "0\n".equals(
/*  53 */         TestUtils.executeCmd("mysql -uroot -pabcd1234 database_activity --execute=\"quit\" 2>/dev/null; echo $?")));
/*     */       
/*  55 */       manager = new StudentManager();
/*  56 */       System.out.println(manager);
/*  57 */       conn = manager.conn;
/*  58 */       Assert.assertNotEquals("StudentManager connection is not initialized", null, conn);
/*  59 */       logger.debug("Connection successfully established!");
/*     */       
/*  61 */       logger.info("OK");
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  65 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test01FindStudentByID() {
/*     */     try {
/*  72 */       manager = new StudentManager();
/*     */       
/*  74 */       Student result = manager.findStudent(1);
/*  75 */       checkStudent(result, "Anna", "Tress", Long.valueOf(1L));
/*  76 */       result = manager.findStudent(2);
/*  77 */       checkStudent(result, "Diana", "Dos", Long.valueOf(2L));
/*     */       
/*  79 */       result = manager.findStudent(-128);
/*  80 */       checkStudent(result, null, null, Long.valueOf(0L));
/*  81 */       logger.info("OK");
/*     */     } catch (Exception e) {
/*  83 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test02FindStudentsByNames()
/*     */   {
/*     */     try {
/*  91 */       List<Student> results = manager.findStudent("AN", "O");
/*  92 */       Assert.assertEquals("findStudent() error.", 2L, results.size());
/*  93 */       checkStudents(results, "Lana", "Uno", Long.valueOf(3L), Integer.valueOf(1));
/*  94 */       checkStudents(results, "Diana", "Dos", Long.valueOf(2L), Integer.valueOf(0));
/*  95 */       results = manager.findStudent("AN", "E");
/*  96 */       Assert.assertEquals("findStudent() result size error.", 1L, results.size());
/*  97 */       checkStudents(results, "Anna", "Tress", Long.valueOf(1L), Integer.valueOf(0));
/*     */       
/*  99 */       results = manager.findStudent("This student", "should NOT be found");
/* 100 */       Assert.assertEquals("findStudent() error for negative search.", 0L, results.size());
/* 101 */       logger.info("OK");
/*     */     } catch (Exception e) {
/* 103 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test03InsertStudent()
/*     */   {
/*     */     try {
/* 111 */       String fname = "testF";
/* 112 */       String lname = "testL";
/* 113 */       boolean result = manager.insertStudent(fname, lname);
/* 114 */       Assert.assertTrue(result);
/* 115 */       List<Student> results = manager.findStudent(fname, lname);
/* 116 */       Assert.assertEquals("findStudent() result size error.", 1L, results.size());
/* 117 */       checkStudents(results, fname, lname);
				clean();
/* 118 */       logger.info("OK");
/*     */     } catch (Exception e) {
/* 120 */       	TestUtils.handleErrorAndFail(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test04InsertStudentAll()
/*     */   {
/*     */     try
/*     */     {
/* 129 */       String fname = "Insert";
/* 130 */       String lname = "All";
/* 131 */       int id = 5;
/* 132 */       boolean result = manager.insertStudentAll(id, fname, lname);
/* 133 */       Assert.assertTrue(result);
/*     */       
/* 135 */       List<Student> results = manager.findStudent(fname, lname);
/* 136 */       Assert.assertEquals("insertStudentAll() results size error.", 1L, results.size());
/* 137 */       checkStudents(results, fname, lname, Long.valueOf(id), Integer.valueOf(0));
/*     */       
/*     */ 
/*     */ 
/* 141 */       result = manager.insertStudentAll(id, fname, lname);
/* 142 */       Assert.assertFalse(result);
/*     */       
/* 144 */       results = manager.findStudent(fname, lname);
/* 145 */       Assert.assertEquals("insertStudentAll() results size error.", 1L, results.size());
/* 146 */       checkStudents(results, fname, lname, Long.valueOf(id), Integer.valueOf(0));
/*     */       
/*     */ 
/* 149 */       fname = "Insert1";
/* 150 */       lname = "All1";
/* 151 */       result = manager.insertStudentAll(id, fname, lname);
/* 152 */       Assert.assertFalse(result);
/*     */       
/* 154 */       results = manager.findStudent(fname, lname);
/* 155 */       Assert.assertEquals("insertStudentAll() results size error.", 0L, results.size());
/* 156 */       logger.info("OK");
/*     */     } catch (Exception e) {
/* 158 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test05UpdateStudent()
/*     */   {
/*     */     try
/*     */     {
/* 167 */       Student Student = new Student(5, fnameToDelete, lnameToDelete);
/* 168 */       boolean result = manager.updateStudent(Student);
/* 169 */       Assert.assertTrue(result);
/* 170 */       List<Student> results = manager.findStudent(fnameToDelete, lnameToDelete);
/* 171 */       Assert.assertEquals("updateStudent() results size error.", 1L, results.size());
/* 172 */       checkStudents(results, fnameToDelete, lnameToDelete, Long.valueOf(idToDelete), Integer.valueOf(0));
/*     */       
/*     */ 
/* 175 */       String fname = "This student";
/* 176 */       String lname = "Should not be updated";
/* 177 */       Student = new Student(123, fname, lname);
/* 178 */       result = manager.updateStudent(Student);
/* 179 */       Assert.assertFalse(result);
/* 180 */       results = manager.findStudent(fname, lname);
/* 181 */       Assert.assertEquals("updateStudent() results size error.", 0L, results.size());
/*     */       
/* 183 */       logger.info("OK");
/*     */     } catch (Exception e) {
/* 185 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test06DeleteStudent()
/*     */   {
/*     */     try
/*     */     {
/* 194 */       boolean result = manager.deleteStudent(idToDelete);
/* 195 */       Assert.assertTrue(result);
/*     */       
/* 197 */       List<Student> results = manager.findStudent(fnameToDelete, lnameToDelete);
/* 198 */       Assert.assertEquals("deleteStudent() results size error.", 0L, results.size());
/*     */       
/* 200 */       result = manager.deleteStudent(idToDelete);
/* 201 */       Assert.assertFalse(result);
/* 202 */       logger.info("OK");
/*     */     } catch (Exception e) {
/* 204 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void test07InjectionTests()
/*     */   {
/*     */     try {
/* 212 */       boolean result = manager.insertStudent("A','A');drop database database_activity;insert into database_activity.Student (firstname, lastname) VALUES ('B", "B");
/*     */       
/* 214 */       Assert.assertTrue(result);
/* 215 */       logger.error("Negative test with SQL injection passed");
/* 216 */       Assert.fail("Negative test with SQL injection passed");
/*     */     } catch (SQLException e) {
/* 218 */       logger.debug("Got expected exception:" + e.getMessage());
/* 219 */       logger.info("OK");
/*     */     } catch (Exception e) {
/* 221 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }
/*     */   
/*     */   @Test
/*     */   public void closeConnection()
/*     */   {
/*     */     try {
/* 229 */       if (manager != null)
/* 230 */         manager.closeConnecion();
/* 231 */       Assert.assertNull("Connection is not set to null when closed.", manager.conn);
/*     */     } catch (Exception e) {
/* 233 */       TestUtils.handleErrorAndFail(e);
/*     */     }
/*     */   }

			public void clean(){
				try {
					java.sql.Statement st = manager.conn.createStatement();
					st.executeQuery("SET SQL_SAFE_UPDATES = 0;");
					PreparedStatement prSt = manager.conn.prepareStatement("delete from database_activity.Student where firstname=?");
					prSt.setString(1, "testF");
					int rs = prSt.executeUpdate();
					java.sql.Statement stm = manager.conn.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
/*     */   
/*     */   public static void resetDatabase() {
/* 238 */     if (dirtyDatabase) {
/*     */       try {
/* 240 */         String workspace = System.getProperty("user.dir");
/* 241 */         TestUtils.executeCmd("mysql -s -uroot -pabcd1234 < " + workspace + "/src/main/java/jtm/activity14/database.sql 2>/dev/null");
/*     */         
/* 243 */         logger.info("Database dump restored");
/* 244 */         dirtyDatabase = false;
/*     */       } catch (Exception e) {
/* 246 */         TestUtils.handleErrorAndFail(e);
/*     */       }
/*     */     } else
/* 249 */       logger.info("Database is clean");
/*     */   }
/*     */   
/*     */   private void checkStudents(List<Student> results, String firstname, String lastname) {
/* 253 */     checkStudents(results, firstname, lastname, null, null);
/*     */   }
/*     */   
/*     */   private void checkStudents(List<Student> results, String firstname, String lastname, Long id, Integer recordno) {
/* 257 */     if (recordno == null)
/* 258 */       recordno = Integer.valueOf(0);
/* 259 */     Assert.assertEquals("Firstname comparison error.", firstname, ((Student)results.get(recordno.intValue())).getFirstName());
/* 260 */     Assert.assertEquals("Lastname comparison error.", lastname, ((Student)results.get(recordno.intValue())).getLastName());
/* 261 */     if (id != null)
/* 262 */       Assert.assertEquals("ID comparison error.", id.longValue(), ((Student)results.get(recordno.intValue())).getID());
/*     */   }
/*     */   
/*     */   private void checkStudent(Student result, String firstname, String lastname, Long id) {
/* 266 */     Assert.assertEquals("Firstname comparison error.", firstname, result.getFirstName());
/* 267 */     Assert.assertEquals("Lastname comparison error.", lastname, result.getLastName());
/* 268 */     if (id != null) {
/* 269 */       Assert.assertEquals("ID comparison error.", id.longValue(), result.getID());
/*     */     }
/*     */   }
/*     */ }
/* Location:           /home/kirils/workspace/Ra9o/lib/JTM.jar
 * Qualified Name:     jtm.activity14.DatabaseUnitTest1
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */
