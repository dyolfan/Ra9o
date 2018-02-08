package jtm.activity16;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jtm.activity13.Teacher;
import jtm.activity13.TeacherManager;

import org.objectweb.asm.commons.Method;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonFormat.Value;

@Controller
public class JettyController {

	TeacherManager manager;

	/**
	 * method which is invoked when root folder (i.e. http://localhost:8080/) of
	 * web application is requested. This method doesn't take any parameters
	 * passed in URL (address).
	 * 
	 * @return string as HTML response to the request using UTF-8 encoding for
	 *         non-Latin characters.
	 */

	@RequestMapping(value = "/", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	// This method should work without declared name parameter, request and
	// response objects,
	// but it shows, how passed request and returned response can be used inside
	// method
	public String homePage(@RequestParam(value = "name", required = false) String name, HttpServletRequest request,
			HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		sb.append("<a href='/insertTeacher'>Insert teacher<a><br/>\n");
		sb.append("<a href='/findTeacher'>Find teacher<a><br/>\n");
		sb.append("<a href='/deleteTeacher'>Delete teacher<a><br/>\n");
		// Following is also redundant because status is OK by default:
		response.setStatus(HttpServletResponse.SC_OK);
		return sb.toString();
	}

	// TODO Implement insertTeacher() method

	@RequestMapping(value = "/insertTeacher", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String insertTeacher(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname, HttpServletRequest request,
			HttpServletResponse response) throws SQLException {
		String names[] = request.getParameterValues("name");
		String surnames[] = request.getParameterValues("surname");
		StringBuilder sb = new StringBuilder();
		if (names == null) {
			sb.append("<form action=''>\n");
			sb.append("Name: <input type='text' name='name' value=''><br/>\n");
			sb.append("Surname:<input type='text' name='surname' value=''><br/>\n");
			sb.append("<input type='submit' value='Insert'></form><br/>\n");
			sb.append("<a href='/'>Back</a>\n");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			manager = new TeacherManager();
			if (!names[0].isEmpty() && !surnames[0].isEmpty()) {
				if (manager.insertTeacher(names[0], surnames[0])) {
					sb.append("true<br/>\n<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_OK);
				} else {
					sb.append("false<br/>\n<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				}
			} else {
				sb.append("false<br/>\n<a href='/'>Back</a>\n");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
		return sb.toString();
	}

	// TODO Implement findTeacher() method
	@RequestMapping(value = "/findTeacher", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String findTeacher(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "surname", required = false) String surname, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String names[] = request.getParameterValues("name");
		String surnames[] = request.getParameterValues("surname");
		StringBuilder sb = new StringBuilder();
		if (names == null) {
			sb.append("<form action=''>\n");
			sb.append("Name: <input type='text' name='name' value=''><br/>\n");
			sb.append("Surname:<input type='text' name='surname' value=''><br/>\n");
			sb.append("<input type='submit' value='Find'><br/>\n");
			sb.append("<a href='/'>Back</a>\n");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			manager = new TeacherManager();
			List<Teacher> arr = new ArrayList<>();
			arr = manager.findTeacher(names[0], surnames[0]);
			sb.append("<form action=''>\n");
			sb.append("Name: <input type='text' name='name' value=''><br/>\n");
			sb.append("Surname:<input type='text' name='surname' value=''><br/>\n");
			sb.append("<input type='submit' value='Find'><br/>\n");
			sb.append("<table>\n");
			sb.append("<tr>\n");
			sb.append("<td>" + arr.get(0).getID() + "</td>\n");
			sb.append("<td>" + arr.get(0).getFirstName() + "</td>\n");
			sb.append("<td>" + arr.get(0).getLastName() + "</td>\n");
			sb.append("</tr>\n");
			sb.append("</table><br>\n");
			sb.append("<a href='/'>Back</a>\n");
			response.setStatus(HttpServletResponse.SC_OK);
		}
		return sb.toString();
	}

	// TODO Implement deleteTeacher() method
	@RequestMapping(value = "/deleteTeacher", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String deleteTeacher(@RequestParam(value = "id", required = false) String id,
			HttpServletRequest request, HttpServletResponse response, Model model) throws NumberFormatException, SQLException {
		String ids[] = request.getParameterValues("id");
		StringBuilder sb = new StringBuilder();
		if (ids == null) {
			sb.append("<form action=''>\n");
			sb.append("ID:<input type='text' name='id' value=''><br/>\n");
			sb.append("<input type='submit' value='Delete'><br/>\n");
			sb.append("<a href='/'>Back</a>\n");
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			manager = new TeacherManager();
			if (!ids[0].isEmpty()) {
				if (manager.deleteTeacher(Integer.parseInt(ids[0]))) {
					sb.append("true<br/>\n<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_OK);
				} else {
					sb.append("false<br/>\n<a href='/'>Back</a>\n");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				}
			} else {
				sb.append("false<br/>\n<a href='/'>Back</a>\n");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}
		return sb.toString();
	}
}
