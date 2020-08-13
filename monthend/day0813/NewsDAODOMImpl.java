import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NewsDAODOMImpl implements INewsDAO{
	
	public NewsDAODOMImpl() {
		
	}
	
	public List<News> getNewsList(String s){
		List<News> list = new ArrayList<News>();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse("./src/com/ssafy/hw/step09/Section902.xml");
			//Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();// 루트 노드
			NodeList itemNodes = root.getElementsByTagName("item");//아이템 이름을 가진 자식을 가져옴
			
			for(int i = 0; i < itemNodes.getLength(); i++){
				News item = new News();
				Node node = itemNodes.item(i);
				
				NodeList childNewsNode= node.getChildNodes();
				
				for(int j = 0; j < childNewsNode.getLength(); j++){
					Node n = childNewsNode.item(j);
					if(n.getNodeType() == Node.ELEMENT_NODE) {
						String textContent = n.getTextContent(); //괄호안의 텍스트를 가져오는 녀석
						String nodeName = n.getNodeName(); //괄호의 이름을 가져오는것
						switch( nodeName ) {
						case "title" 	: 
							item.setTitle(textContent);
							break;
						case "link" 	: 
							item.setLink(textContent);
							break;
						case "description" 	: 
							item.setDesc(textContent);
							break;
						case "guid" 	: 
							item.setGuid(textContent);
							break;
						}
					}
				}
				
				list.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public News Search(String Guid) {
		News output = new News();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse("./src/com/ssafy/hw/step09/Section902.xml");
			//Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();// 루트 노드
			NodeList itemNodes = root.getElementsByTagName("item");//아이템 이름을 가진 자식을 가져옴
			
			for(int i = 0; i < itemNodes.getLength(); i++){
				Node node = itemNodes.item(i);
				boolean flag = false;
				NodeList childNewsNode= node.getChildNodes();
				
				for(int j = 0; j < childNewsNode.getLength(); j++){
					Node n = childNewsNode.item(j);
					if(n.getNodeType() == Node.ELEMENT_NODE) {
						String textContent = n.getTextContent(); //괄호안의 텍스트를 가져오는 녀석
						String nodeName = n.getNodeName(); //괄호의 이름을 가져오는것
						if(nodeName.equals("guid") && textContent.equals(Guid) ) {
							flag = true;
							break;
						}
					}
				}
				
				if(flag) {
					for(int j = 0; j < childNewsNode.getLength(); j++){
						Node n = childNewsNode.item(j);

						String textContent = n.getTextContent(); //괄호안의 텍스트를 가져오는 녀석
						String nodeName = n.getNodeName(); //괄호의 이름을 가져오는것

						switch( nodeName ) {
						case "title" 	: 
							output.setTitle(textContent);
							break;
						case "link" 	: 
							output.setLink(textContent);
							break;
						case "description" 	: 
							output.setDesc(textContent);
							break;
						case "guid" 	: 
							output.setGuid(textContent);
							break;
						}
					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return output;
	}
	
	
	private void connectNews(String s) {
		
		
	}
}
