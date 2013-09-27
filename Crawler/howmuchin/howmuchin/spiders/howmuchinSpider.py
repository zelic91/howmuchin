from scrapy.spider 			import BaseSpider
from scrapy.selector 		import HtmlXPathSelector
from scrapy.http			import Request
from howmuchin.items		import HowmuchinItem
import re
 
class HowMuchInSpider(BaseSpider):
	name 			= "howmuchin"
	allowed_domains	= ["flagpedia.net"]
	start_urls		= ["http://flagpedia.net"]
 
	def parse(self, response):
		host 			= self.start_urls[0];
		hxs 			= HtmlXPathSelector(response)
		links			= hxs.select("//@href").extract()

 
		#We stored already crawled links in this list
		crawledLinks 	= []
 
		#Pattern to check proper link
		linkPattern 	= re.compile("(^/[a-zA-Z-]+$)|(^/index/[a-z]$)")
 
		for link in links:
			# If it is a proper link and is not checked yet, yield it to the Spider
			if linkPattern.match(link) and not link in crawledLinks:
				crawledLinks.append(link)
				yield Request(host+link, self.parse)
		
		image = hxs.select('//div[@id="obsah"]/p/img/@src').extract()

		print image
		if len(image)>0:
			item = HowmuchinItem()
			item['image_urls']=[]
			item['image_urls'].append(host+image[0])
			yield item