package edu.jsu.mcis.cs310;

import com.github.cliftonlabs.json_simple.*;
import com.opencsv.*;

public class Converter {
    
    /*
        
        Consider the following CSV data, a portion of a database of episodes of
        the classic "Star Trek" television series:
        
        "ProdNum","Title","Season","Episode","Stardate","OriginalAirdate","RemasteredAirdate"
        "6149-02","Where No Man Has Gone Before","1","01","1312.4 - 1313.8","9/22/1966","1/20/2007"
        "6149-03","The Corbomite Maneuver","1","02","1512.2 - 1514.1","11/10/1966","12/9/2006"
        
        (For brevity, only the header row plus the first two episodes are shown
        in this sample.)
    
        The corresponding JSON data would be similar to the following; tabs and
        other whitespace have been added for clarity.  Note the curly braces,
        square brackets, and double-quotes!  These indicate which values should
        be encoded as strings and which values should be encoded as integers, as
        well as the overall structure of the data:
        
        {
            "ProdNums": [
                "6149-02",
                "6149-03"
            ],
            "ColHeadings": [
                "ProdNum",
                "Title",
                "Season",
                "Episode",
                "Stardate",
                "OriginalAirdate",
                "RemasteredAirdate"
            ],
            "Data": [
                [
                    "Where No Man Has Gone Before",
                    1,
                    1,
                    "1312.4 - 1313.8",
                    "9/22/1966",
                    "1/20/2007"
                ],
                [
                    "The Corbomite Maneuver",
                    1,
                    2,
                    "1512.2 - 1514.1",
                    "11/10/1966",
                    "12/9/2006"
                ]
            ]
        }
        
        Your task for this program is to complete the two conversion methods in
        this class, "csvToJson()" and "jsonToCsv()", so that the CSV data shown
        above can be converted to JSON format, and vice-versa.  Both methods
        should return the converted data as strings, but the strings do not need
        to include the newlines and whitespace shown in the examples; again,
        this whitespace has been added only for clarity.
        
        NOTE: YOU SHOULD NOT WRITE ANY CODE WHICH MANUALLY COMPOSES THE OUTPUT
        STRINGS!!!  Leave ALL string conversion to the two data conversion
        libraries we have discussed, OpenCSV and json-simple.  See the "Data
        Exchange" lecture notes for more details, including examples.
        
    */
    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) {
        
        String result = "{}"; // default return value; replace later!
        
        try {
        
            // INSERT YOUR CODE HERE
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return result.trim();
        
    }
    
    @SuppressWarnings("unchecked")
    public static String jsonToCsv(String jsonString) {
        
        String result = ""; // default return value; replace later!
        
        try {
            
            import { altX, commentX, lineAttrX } from './regex';
import { isEmpty } from './isEmpty';

const capComment = 1;
const capSelector = 2;
const capEnd = 3;
const capAttr = 4;

/**
 * Input is css string and current pos, returns JSON object
 *
 * @param cssString
 *            The CSS string.
 * @param args
 *            An optional argument object. ordered: Whether order of
 *            comments and other nodes should be kept in the output. This
 *            will return an object where all the keys are numbers and the
 *            values are objects containing "name" and "value" keys for each
 *            node. comments: Whether to capture comments. split: Whether to
 *            split each comma separated list of selectors.
 */
const defaultArgs = {
  ordered: false,
  comments: false,
  stripComments: false,
  split: false,
};

export interface CssAttributes {
  [attribute: string]: string
}

export interface Children {
  [attribute: string]: {
    children: Children,
    attributes: CssAttributes
  }
}

export interface JSONNode {
  children: Children,
  attributes: CssAttributes
}

export const toJSON = function (
  cssString: string,
  args = defaultArgs
): JSONNode {
  const node: any = {
    children: {},
    attributes: {},
  };
  let match: any = null;
  let count = 0;

  if (args.stripComments) {
    args.comments = false;
    cssString = cssString.replace(commentX, '');
  }

  while ((match = altX.exec(cssString)) != null) {
    if (!isEmpty(match[capComment]) && args.comments) {
      // Comment
      node[count++] = match[capComment].trim();
    } else if (!isEmpty(match[capSelector])) {
      // New node, we recurse
      const name = match[capSelector].trim();
      // This will return when we encounter a closing brace
      const newNode = toJSON(cssString, args);
      if (args.ordered) {
        // Since we must use key as index to keep order and not
        // name, this will differentiate between a Rule Node and an
        // Attribute, since both contain a name and value pair.
        node[count++] = { name, value: newNode, type: 'rule' };
      } else {
        const bits = args.split ? name.split(',') : [name];
        for (const i in bits) {
          const sel = bits[i].trim();
          if (sel in node.children) {
            for (const att in newNode.attributes) {
              node.children[sel].attributes[att] = newNode.attributes[att];
            }
          } else {
            node.children[sel] = JSON.parse(JSON.stringify(newNode));
          }
        }
      }
    } else if (!isEmpty(match[capEnd])) {
      // Node has finished
      return node;
    } else if (!isEmpty(match[capAttr])) {
      const line = match[capAttr].trim();
      const attr = lineAttrX.exec(line);
      if (attr) {
        // Attribute
        const name = attr[1].trim();
        const value = attr[2].trim();
        if (args.ordered) {
          node[count++] = { name, value, type: 'attr' };
        } else {
          if (name in node.attributes) {
            const currVal = node.attributes[name];
            if (!(currVal instanceof Array)) {
              node.attributes[name] = [currVal];
            }
            node.attributes[name].push(value);
          } else {
            node.attributes[name] = value;
          }
        }
      } else {
        // Semicolon terminated line
        node[count++] = line;
      }
    }
  }

  return node;
};
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return result.trim();
        
    }
    
}
